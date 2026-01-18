package main;

import ui.CreateProfilePanel;
import ui.ViewProfilePanel;

import javax.swing.*;
import java.awt.*;

/**
 * 主程序入口，创建JFrame和JSplitPane，整合创建/查看面板
 */
public class PersonProfileMain {
    public static void main(String[] args) {
        // Swing UI必须在事件调度线程中运行
        SwingUtilities.invokeLater(() -> {
            // 1. 创建主窗口
            JFrame frame = new JFrame("Person Profile Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 800);
            frame.setLocationRelativeTo(null); // 居中显示

            // 2. 创建查看面板（先创建，因为创建面板需要引用）
            ViewProfilePanel viewPanel = new ViewProfilePanel();

            // 3. 创建输入面板
            CreateProfilePanel createPanel = new CreateProfilePanel(viewPanel);

            // 4. 创建JSplitPane（左右分割，左边创建，右边查看）
            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, createPanel, viewPanel);
            splitPane.setDividerLocation(500); // 设置分割线位置
            splitPane.setOneTouchExpandable(true); // 显示展开/折叠按钮

            // 5. 添加分割面板到窗口
            frame.add(splitPane, BorderLayout.CENTER);

            // 6. 显示窗口
            frame.setVisible(true);
        });
    }
}
