/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.legrange.panstamp.gui;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author gideon
 */
class ConfigDialog extends javax.swing.JDialog {

    /**
     * Creates new form ConfigDialog
     *
     * @param config
     * @param parent
     * @param modal
     */
    ConfigDialog(Config config, java.awt.Frame parent) {
        super(parent, true);
        this.config = config;
        initComponents();
    }

    private ComboBoxModel<String> portListModel() {
        DefaultComboBoxModel<String> mod = new DefaultComboBoxModel<>();
        for (String port : config.getPorts()) {
            mod.addElement(port);
            if (port.equals(config.getPortName())) {
                mod.setSelectedItem(port);
            }
        }
        return mod;
    }

    private ComboBoxModel<Integer> speedListModel() {
        DefaultComboBoxModel<Integer> mod = new DefaultComboBoxModel<>();
        for (Integer speed : config.getSpeeds()) {
            mod.addElement(speed);
            if (speed.equals(config.getPortSpeed())) {
                mod.setSelectedItem(speed);
            }
        }
        return mod;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        configTabs = new javax.swing.JTabbedPane();
        serialTab = new javax.swing.JPanel();
        portLabel = new javax.swing.JLabel();
        speedLabel = new javax.swing.JLabel();
        speedComboBox = new javax.swing.JComboBox();
        portComboBox = new javax.swing.JComboBox();
        networkTab = new javax.swing.JPanel();
        networkIDLabel = new javax.swing.JLabel();
        channelTextField = new javax.swing.JTextField();
        frequencyLabel = new javax.swing.JLabel();
        networkTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        securityLabel = new javax.swing.JLabel();
        securityTextField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setSize(new java.awt.Dimension(320, 200));

        portLabel.setText("Port:");

        speedLabel.setText("Speed (bps):");

        speedComboBox.setModel(speedListModel());
        speedComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speedComboBoxActionPerformed(evt);
            }
        });

        portComboBox.setModel(portListModel());
        portComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout serialTabLayout = new javax.swing.GroupLayout(serialTab);
        serialTab.setLayout(serialTabLayout);
        serialTabLayout.setHorizontalGroup(
            serialTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serialTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(serialTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(speedLabel)
                    .addComponent(portLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(serialTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(portComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(speedComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        serialTabLayout.setVerticalGroup(
            serialTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serialTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(serialTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portLabel))
                .addGap(16, 16, 16)
                .addGroup(serialTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(speedLabel)
                    .addComponent(speedComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        configTabs.addTab("Serial port", serialTab);

        networkIDLabel.setText("Network ID:");

        frequencyLabel.setText("Frequency channel:");
        frequencyLabel.setToolTipText("");

        addressLabel.setText("Device address:");

        securityLabel.setText("Security option:");

        javax.swing.GroupLayout networkTabLayout = new javax.swing.GroupLayout(networkTab);
        networkTab.setLayout(networkTabLayout);
        networkTabLayout.setHorizontalGroup(
            networkTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(networkTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(networkTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frequencyLabel)
                    .addComponent(networkIDLabel)
                    .addComponent(addressLabel)
                    .addComponent(securityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(networkTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addressTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(networkTextField)
                    .addComponent(channelTextField)
                    .addComponent(securityTextField))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        networkTabLayout.setVerticalGroup(
            networkTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(networkTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(networkTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(frequencyLabel)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(networkTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(networkIDLabel)
                    .addComponent(networkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(networkTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(channelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(networkTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(securityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(securityLabel))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        configTabs.addTab("Network settings", networkTab);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(configTabs)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(configTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
       
    }//GEN-LAST:event_okButtonActionPerformed

    private void speedComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speedComboBoxActionPerformed
        config.setPortSpeed((Integer) speedComboBox.getModel().getSelectedItem());
    }//GEN-LAST:event_speedComboBoxActionPerformed

    private void portComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portComboBoxActionPerformed
        config.setPortName((String) portComboBox.getModel().getSelectedItem());
    }//GEN-LAST:event_portComboBoxActionPerformed

    private final Config config;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField channelTextField;
    private javax.swing.JTabbedPane configTabs;
    private javax.swing.JLabel frequencyLabel;
    private javax.swing.JLabel networkIDLabel;
    private javax.swing.JPanel networkTab;
    private javax.swing.JTextField networkTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox portComboBox;
    private javax.swing.JLabel portLabel;
    private javax.swing.JLabel securityLabel;
    private javax.swing.JTextField securityTextField;
    private javax.swing.JPanel serialTab;
    private javax.swing.JComboBox speedComboBox;
    private javax.swing.JLabel speedLabel;
    // End of variables declaration//GEN-END:variables
}
