package ui;

import model.Address;
import model.BankAccount;
import model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 创建个人信息面板，包含所有输入字段和验证逻辑
 */
public class CreateProfilePanel extends JPanel {
    // 个人信息组件
    private JTextField txtFirstName, txtLastName, txtAge;
    private JRadioButton rdoMarried, rdoUnmarried;
    private ButtonGroup grpMaritalStatus;

    // 家庭地址组件
    private JTextField txtHomeStreet, txtHomeCity, txtHomeState, txtHomeZip, txtHomeHouseNum, txtHomeCountry;

    // 本地地址组件
    private JTextField txtLocalStreet, txtLocalCity, txtLocalState, txtLocalZip, txtLocalHouseNum, txtLocalCountry;

    // 银行账户组件
    private JTextField txtAccountNum, txtAccountType, txtBalance, txtBranchCode, txtInterestRate;
    private JRadioButton rdoActive, rdoInactive;
    private ButtonGroup grpAccountStatus;

    // 查看面板引用（用于传递数据）
    private ViewProfilePanel viewPanel;

    // 构造器：初始化UI+绑定查看面板
    public CreateProfilePanel(ViewProfilePanel viewPanel) {
        this.viewPanel = viewPanel;
        initUI();
    }

    // 初始化UI布局
    private void initUI() {
        setLayout(new GridLayout(3, 1, 10, 10)); // 分3大块：个人信息、地址、银行账户
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 1. 个人信息面板
        JPanel pnlPersonal = new JPanel(new GridLayout(5, 2, 5, 5));
        pnlPersonal.setBorder(BorderFactory.createTitledBorder("Personal Information"));
        pnlPersonal.add(new JLabel("First Name:"));
        txtFirstName = new JTextField();
        pnlPersonal.add(txtFirstName);

        pnlPersonal.add(new JLabel("Last Name:"));
        txtLastName = new JTextField();
        pnlPersonal.add(txtLastName);

        pnlPersonal.add(new JLabel("Age:"));
        txtAge = new JTextField();
        pnlPersonal.add(txtAge);

        pnlPersonal.add(new JLabel("Marital Status:"));
        JPanel pnlMarital = new JPanel(new FlowLayout());
        rdoMarried = new JRadioButton("Married");
        rdoUnmarried = new JRadioButton("Unmarried");
        grpMaritalStatus = new ButtonGroup();
        grpMaritalStatus.add(rdoMarried);
        grpMaritalStatus.add(rdoUnmarried);
        pnlMarital.add(rdoMarried);
        pnlMarital.add(rdoUnmarried);
        pnlPersonal.add(pnlMarital);

        // 2. 地址面板（家庭+本地）
        JPanel pnlAddress = new JPanel(new GridLayout(2, 1, 5, 5));
        // 家庭地址
        JPanel pnlHomeAddr = new JPanel(new GridLayout(6, 2, 5, 5));
        pnlHomeAddr.setBorder(BorderFactory.createTitledBorder("Home Address"));
        pnlHomeAddr.add(new JLabel("Street:"));
        txtHomeStreet = new JTextField();
        pnlHomeAddr.add(txtHomeStreet);
        pnlHomeAddr.add(new JLabel("City:"));
        txtHomeCity = new JTextField();
        pnlHomeAddr.add(txtHomeCity);
        pnlHomeAddr.add(new JLabel("State:"));
        txtHomeState = new JTextField();
        pnlHomeAddr.add(txtHomeState);
        pnlHomeAddr.add(new JLabel("Zip Code:"));
        txtHomeZip = new JTextField();
        pnlHomeAddr.add(txtHomeZip);
        pnlHomeAddr.add(new JLabel("House Number:"));
        txtHomeHouseNum = new JTextField();
        pnlHomeAddr.add(txtHomeHouseNum);
        pnlHomeAddr.add(new JLabel("Country:"));
        txtHomeCountry = new JTextField();
        pnlHomeAddr.add(txtHomeCountry);

        // 本地地址
        JPanel pnlLocalAddr = new JPanel(new GridLayout(6, 2, 5, 5));
        pnlLocalAddr.setBorder(BorderFactory.createTitledBorder("Local Address"));
        pnlLocalAddr.add(new JLabel("Street:"));
        txtLocalStreet = new JTextField();
        pnlLocalAddr.add(txtLocalStreet);
        pnlLocalAddr.add(new JLabel("City:"));
        txtLocalCity = new JTextField();
        pnlLocalAddr.add(txtLocalCity);
        pnlLocalAddr.add(new JLabel("State:"));
        txtLocalState = new JTextField();
        pnlLocalAddr.add(txtLocalState);
        pnlLocalAddr.add(new JLabel("Zip Code:"));
        txtLocalZip = new JTextField();
        pnlLocalAddr.add(txtLocalZip);
        pnlLocalAddr.add(new JLabel("House Number:"));
        txtLocalHouseNum = new JTextField();
        pnlLocalAddr.add(txtLocalHouseNum);
        pnlLocalAddr.add(new JLabel("Country:"));
        txtLocalCountry = new JTextField();
        pnlLocalAddr.add(txtLocalCountry);

        pnlAddress.add(pnlHomeAddr);
        pnlAddress.add(pnlLocalAddr);

        // 3. 银行账户面板
        JPanel pnlBank = new JPanel(new GridLayout(7, 2, 5, 5));
        pnlBank.setBorder(BorderFactory.createTitledBorder("Bank Account"));
        pnlBank.add(new JLabel("Account Number:"));
        txtAccountNum = new JTextField();
        pnlBank.add(txtAccountNum);
        pnlBank.add(new JLabel("Account Type:"));
        txtAccountType = new JTextField();
        pnlBank.add(txtAccountType);
        pnlBank.add(new JLabel("Balance ($):"));
        txtBalance = new JTextField();
        pnlBank.add(txtBalance);
        pnlBank.add(new JLabel("Branch Code:"));
        txtBranchCode = new JTextField();
        pnlBank.add(txtBranchCode);
        pnlBank.add(new JLabel("Interest Rate (%):"));
        txtInterestRate = new JTextField();
        pnlBank.add(txtInterestRate);
        pnlBank.add(new JLabel("Account Status:"));
        JPanel pnlAccountStatus = new JPanel(new FlowLayout());
        rdoActive = new JRadioButton("Active");
        rdoInactive = new JRadioButton("Inactive");
        grpAccountStatus = new ButtonGroup();
        grpAccountStatus.add(rdoActive);
        grpAccountStatus.add(rdoInactive);
        pnlAccountStatus.add(rdoActive);
        pnlAccountStatus.add(rdoInactive);
        pnlBank.add(pnlAccountStatus);

        // 按钮面板
        JPanel pnlButtons = new JPanel(new FlowLayout());
        JButton btnSave = new JButton("Save Profile");
        JButton btnShow = new JButton("Show Profile");
        pnlButtons.add(btnSave);
        pnlButtons.add(btnShow);
        pnlBank.add(new JLabel()); // 占位
        pnlBank.add(pnlButtons);

        // 添加所有面板到主面板
        add(pnlPersonal);
        add(pnlAddress);
        add(pnlBank);

        // 绑定按钮事件
        btnSave.addActionListener(new SaveButtonListener());
        btnShow.addActionListener(new ShowButtonListener());
    }

    // 保存按钮监听器（核心：输入验证+创建Person对象）
    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 1. 非空验证
            if (!validateEmptyFields()) {
                JOptionPane.showMessageDialog(null, "Error: All fields cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 2. 数据类型验证
            try {
                // 解析数字字段
                int age = Integer.parseInt(txtAge.getText().trim());
                int homeZip = Integer.parseInt(txtHomeZip.getText().trim());
                int homeHouseNum = Integer.parseInt(txtHomeHouseNum.getText().trim());
                int localZip = Integer.parseInt(txtLocalZip.getText().trim());
                int localHouseNum = Integer.parseInt(txtLocalHouseNum.getText().trim());
                double balance = Double.parseDouble(txtBalance.getText().trim());
                int branchCode = Integer.parseInt(txtBranchCode.getText().trim());
                double interestRate = Double.parseDouble(txtInterestRate.getText().trim());

                // 3. 创建Address对象
                Address homeAddr = new Address(
                        txtHomeStreet.getText().trim(),
                        txtHomeCity.getText().trim(),
                        txtHomeState.getText().trim(),
                        homeZip,
                        homeHouseNum,
                        txtHomeCountry.getText().trim()
                );
                Address localAddr = new Address(
                        txtLocalStreet.getText().trim(),
                        txtLocalCity.getText().trim(),
                        txtLocalState.getText().trim(),
                        localZip,
                        localHouseNum,
                        txtLocalCountry.getText().trim()
                );

                // 4. 创建BankAccount对象
                BankAccount bankAccount = new BankAccount(
                        txtAccountNum.getText().trim(),
                        txtAccountType.getText().trim(),
                        balance,
                        rdoActive.isSelected(),
                        branchCode,
                        interestRate
                );

                // 5. 创建Person对象
                Person person = new Person(
                        txtFirstName.getText().trim(),
                        txtLastName.getText().trim(),
                        age,
                        rdoMarried.isSelected(),
                        homeAddr,
                        localAddr,
                        bankAccount
                );

                // 6. 保存成功提示
                JOptionPane.showMessageDialog(null, "Profile saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                // 数字类型验证失败
                JOptionPane.showMessageDialog(null, "Error: Please enter valid numeric values for age, zip code, balance, etc.", "Data Type Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // 显示按钮监听器（传递Person对象到查看面板）
    private class ShowButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 复用保存的验证逻辑
            if (!validateEmptyFields()) {
                JOptionPane.showMessageDialog(null, "Error: All fields cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // 解析数字字段
                int age = Integer.parseInt(txtAge.getText().trim());
                int homeZip = Integer.parseInt(txtHomeZip.getText().trim());
                int homeHouseNum = Integer.parseInt(txtHomeHouseNum.getText().trim());
                int localZip = Integer.parseInt(txtLocalZip.getText().trim());
                int localHouseNum = Integer.parseInt(txtLocalHouseNum.getText().trim());
                double balance = Double.parseDouble(txtBalance.getText().trim());
                int branchCode = Integer.parseInt(txtBranchCode.getText().trim());
                double interestRate = Double.parseDouble(txtInterestRate.getText().trim());

                // 创建对象
                Address homeAddr = new Address(txtHomeStreet.getText().trim(), txtHomeCity.getText().trim(), txtHomeState.getText().trim(), homeZip, homeHouseNum, txtHomeCountry.getText().trim());
                Address localAddr = new Address(txtLocalStreet.getText().trim(), txtLocalCity.getText().trim(), txtLocalState.getText().trim(), localZip, localHouseNum, txtLocalCountry.getText().trim());
                BankAccount bankAccount = new BankAccount(txtAccountNum.getText().trim(), txtAccountType.getText().trim(), balance, rdoActive.isSelected(), branchCode, interestRate);
                Person person = new Person(txtFirstName.getText().trim(), txtLastName.getText().trim(), age, rdoMarried.isSelected(), homeAddr, localAddr, bankAccount);

                // 传递到查看面板显示
                viewPanel.setPerson(person);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error: Please enter valid numeric values!", "Data Type Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // 非空验证方法（检查所有输入框是否为空）
    private boolean validateEmptyFields() {
        // 个人信息
        if (txtFirstName.getText().trim().isEmpty() || txtLastName.getText().trim().isEmpty() || txtAge.getText().trim().isEmpty() ||
                !rdoMarried.isSelected() && !rdoUnmarried.isSelected()) {
            return false;
        }

        // 家庭地址
        if (txtHomeStreet.getText().trim().isEmpty() || txtHomeCity.getText().trim().isEmpty() || txtHomeState.getText().trim().isEmpty() ||
                txtHomeZip.getText().trim().isEmpty() || txtHomeHouseNum.getText().trim().isEmpty() || txtHomeCountry.getText().trim().isEmpty()) {
            return false;
        }

        // 本地地址
        if (txtLocalStreet.getText().trim().isEmpty() || txtLocalCity.getText().trim().isEmpty() || txtLocalState.getText().trim().isEmpty() ||
                txtLocalZip.getText().trim().isEmpty() || txtLocalHouseNum.getText().trim().isEmpty() || txtLocalCountry.getText().trim().isEmpty()) {
            return false;
        }

        // 银行账户
        if (txtAccountNum.getText().trim().isEmpty() || txtAccountType.getText().trim().isEmpty() || txtBalance.getText().trim().isEmpty() ||
                txtBranchCode.getText().trim().isEmpty() || txtInterestRate.getText().trim().isEmpty() ||
                !rdoActive.isSelected() && !rdoInactive.isSelected()) {
            return false;
        }

        return true;
    }
}