
package ui;

import model.Person;

import javax.swing.*;
import java.awt.*;

/**
 * 查看个人信息面板，显示所有保存的Person属性
 */
public class ViewProfilePanel extends JPanel {
    // 显示组件（不可编辑）
    private JTextField txtFullName, txtAge, txtMaritalStatus;
    private JTextField txtHomeAddress, txtLocalAddress;
    private JTextField txtBankAccount;

    // 构造器：初始化UI
    public ViewProfilePanel() {
        initUI();
    }

    // 初始化UI布局
    private void initUI() {
        setLayout(new GridLayout(5, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBorder(BorderFactory.createTitledBorder("View Person Profile"));

        // 添加标签和显示框
        add(new JLabel("Full Name:"));
        txtFullName = new JTextField();
        txtFullName.setEditable(false);
        add(txtFullName);

        add(new JLabel("Age:"));
        txtAge = new JTextField();
        txtAge.setEditable(false);
        add(txtAge);

        add(new JLabel("Marital Status:"));
        txtMaritalStatus = new JTextField();
        txtMaritalStatus.setEditable(false);
        add(txtMaritalStatus);

        add(new JLabel("Home Address:"));
        txtHomeAddress = new JTextField();
        txtHomeAddress.setEditable(false);
        add(txtHomeAddress);

        add(new JLabel("Local Address:"));
        txtLocalAddress = new JTextField();
        txtLocalAddress.setEditable(false);
        add(txtLocalAddress);

        add(new JLabel("Bank Account:"));
        txtBankAccount = new JTextField();
        txtBankAccount.setEditable(false);
        add(txtBankAccount);
    }

    // 核心方法：接收Person对象并更新显示
    public void setPerson(Person person) {
        // 更新个人信息
        txtFullName.setText(person.getFirstName() + " " + person.getLastName());
        txtAge.setText(String.valueOf(person.getAge()));
        txtMaritalStatus.setText(person.isMarried() ? "Married" : "Unmarried");

        // 更新地址
        txtHomeAddress.setText(person.getHomeAddress().toString());
        txtLocalAddress.setText(person.getLocalAddress().toString());

        // 更新银行账户
        txtBankAccount.setText(person.getBankAccount().toString());
    }
}