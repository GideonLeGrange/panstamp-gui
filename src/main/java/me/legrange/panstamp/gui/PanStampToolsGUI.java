package me.legrange.panstamp.gui;

import me.legrange.panstamp.gui.osx.AppleExtension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import me.legrange.panstamp.Network;
import me.legrange.panstamp.NetworkException;
import me.legrange.panstamp.gui.model.Model;
import me.legrange.panstamp.gui.view.View;
import me.legrange.panstamp.tools.store.DataStoreException;

/**
 *
 * @author gideon
 */
public class PanStampToolsGUI extends javax.swing.JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            if (AppleExtension.isOSX()) {
                System.setProperty("apple.awt.graphics.EnableQ2DX", "true");
                System.setProperty("apple.laf.useScreenMenuBar", "true");
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(PanStampToolsGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("System".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanStampToolsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    final PanStampToolsGUI mw = new PanStampToolsGUI();
                    if (AppleExtension.isOSX()) {
                        AppleExtension.apply(mw);
                        mw.panStampMenu.setVisible(false);
                    }
                    mw.setVisible(true);
                    mw.start();
                } catch (DataStoreException ex) {
                    Logger.getLogger(PanStampToolsGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NetworkException ex) {
                    Logger.getLogger(PanStampToolsGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(PanStampToolsGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * Creates new form MainWindow
     *
     * @throws me.legrange.panstamp.tools.store.DataStoreException
     */
    public PanStampToolsGUI() throws DataStoreException {
        model = new Model();
        view = new View(this, model);
        initComponents();
        setLocationRelativeTo(null);
    
        mainMenu.add(view.getWorldMenu());
        mainMenu.add(view.getGatewayMenu());
        mainMenu.add(view.getDeviceMenu());
      //  mainMenu.add(view.getRegisterMenu());
        mainMenu.add(view.getEndpointMenu());
    }

    public JTree getNetworkTree() {
        return networkTree;
    }

    /**
     * start the application
     */
    private void start() throws NetworkException {
        model.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftRightSplitPane = new javax.swing.JSplitPane();
        topBottomSplitPane = new javax.swing.JSplitPane();
        topPanel = new javax.swing.JPanel();
        swapMessagesPane = new javax.swing.JScrollPane();
        swapMessagesTable = new javax.swing.JTable();
        bottomPanel = new javax.swing.JPanel();
        eventPanel = new javax.swing.JScrollPane();
        eventTable = new javax.swing.JTable();
        leftPanel = new javax.swing.JPanel();
        swapNetworkPane = new javax.swing.JScrollPane();
        networkTree = new javax.swing.JTree();
        mainMenu = new javax.swing.JMenuBar();
        panStampMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        configMenuItem = new javax.swing.JMenuItem();
        quitItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Courier", 0, 10)); // NOI18N
        setMinimumSize(new java.awt.Dimension(800, 600));

        leftRightSplitPane.setBorder(null);
        leftRightSplitPane.setDividerLocation(290);
        leftRightSplitPane.setDividerSize(0);

        topBottomSplitPane.setBorder(null);
        topBottomSplitPane.setDividerLocation(280);
        topBottomSplitPane.setDividerSize(0);
        topBottomSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        topPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "SWAP Messages", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13)), javax.swing.BorderFactory.createEmptyBorder(2, 4, 2, 4))); // NOI18N
        topPanel.setLayout(new java.awt.BorderLayout());

        swapMessagesTable.setFont(new java.awt.Font("Courier", 0, 12)); // NOI18N
        swapMessagesTable.setModel(model.getSWAPTableModel());
        swapMessagesTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        swapMessagesTable.getColumnModel().getColumn(0).setMinWidth(100);
        swapMessagesTable.getColumnModel().getColumn(0).setMaxWidth(100);
        swapMessagesTable.getColumnModel().getColumn(1).setPreferredWidth(61);
        swapMessagesTable.getColumnModel().getColumn(1).setMinWidth(61);
        swapMessagesTable.getColumnModel().getColumn(1).setMaxWidth(61);
        swapMessagesTable.getColumnModel().getColumn(2).setPreferredWidth(48);
        swapMessagesTable.getColumnModel().getColumn(2).setMinWidth(48);
        swapMessagesTable.getColumnModel().getColumn(2).setMaxWidth(48);
        swapMessagesTable.getColumnModel().getColumn(3).setPreferredWidth(160);
        swapMessagesTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        swapMessagesTable.setMinimumSize(new java.awt.Dimension(480, 250));
        swapMessagesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        swapMessagesTable.setShowGrid(false);
        swapMessagesTable.getTableHeader().setReorderingAllowed(false);
        swapMessagesPane.setViewportView(swapMessagesTable);

        topPanel.add(swapMessagesPane, java.awt.BorderLayout.CENTER);

        topBottomSplitPane.setTopComponent(topPanel);

        bottomPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Network Events"));
        bottomPanel.setLayout(new java.awt.BorderLayout());

        eventTable.setModel(model.getEndpointTableModel());
        eventTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        eventTable.setMinimumSize(new java.awt.Dimension(480, 250));
        eventTable.getColumnModel().getColumn(0).setMinWidth(100);
        eventTable.getColumnModel().getColumn(0).setMaxWidth(100);
        eventPanel.setViewportView(eventTable);

        bottomPanel.add(eventPanel, java.awt.BorderLayout.CENTER);

        topBottomSplitPane.setRightComponent(bottomPanel);

        leftRightSplitPane.setRightComponent(topBottomSplitPane);

        leftPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "SWAP Network", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13)), javax.swing.BorderFactory.createEmptyBorder(2, 4, 2, 4))); // NOI18N
        leftPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        leftPanel.setLayout(new java.awt.BorderLayout());

        networkTree.setModel(model.getTreeModel());
        networkTree.setCellRenderer(view.getTreeCellRenderer());
        networkTree.setSelectionModel(new DefaultTreeSelectionModel());
        networkTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                networkTreeMouseClicked(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                networkTreeMouseClicked(evt);
            }
        });
        swapNetworkPane.setViewportView(networkTree);

        leftPanel.add(swapNetworkPane, java.awt.BorderLayout.CENTER);

        leftRightSplitPane.setLeftComponent(leftPanel);

        panStampMenu.setText("panStamp Tools GUI");
        panStampMenu.setAutoscrolls(true);

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        panStampMenu.add(aboutMenuItem);

        configMenuItem.setText("Preferences");
        configMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configMenuItemActionPerformed(evt);
            }
        });
        panStampMenu.add(configMenuItem);

        quitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        quitItem.setText("Quit");
        quitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitItemActionPerformed(evt);
            }
        });
        panStampMenu.add(quitItem);

        mainMenu.add(panStampMenu);

        setJMenuBar(mainMenu);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(leftRightSplitPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(leftRightSplitPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitItemActionPerformed
        quit();
    }//GEN-LAST:event_quitItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        showAbout();
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void networkTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_networkTreeMouseClicked
        TreePath path = networkTree.getClosestPathForLocation(evt.getX(), evt.getY());
        if (!evt.isPopupTrigger()) {
            JPopupMenu menu = view.getTreePopupMenu(path);
            networkTree.setComponentPopupMenu(menu);
        }

    }//GEN-LAST:event_networkTreeMouseClicked

    private void configMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configMenuItemActionPerformed
        showPreferences();
    }//GEN-LAST:event_configMenuItemActionPerformed

    public void quit() {
        System.exit(0);
    }

    public void showAbout() {
        AboutDialog ad = new AboutDialog(this, true);
        ad.setVisible(true);
    }

    public void showPreferences() {
        PreferencesDialog pd;
        try {
            pd = new PreferencesDialog(this, model);
            pd.setVisible(true);
        } catch (DataStoreException ex) {
            Logger.getLogger(PanStampToolsGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Network gw;
    private final Model model;
    private final View view;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JMenuItem configMenuItem;
    private javax.swing.JScrollPane eventPanel;
    private javax.swing.JTable eventTable;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JSplitPane leftRightSplitPane;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JTree networkTree;
    private javax.swing.JMenu panStampMenu;
    private javax.swing.JMenuItem quitItem;
    private javax.swing.JScrollPane swapMessagesPane;
    private javax.swing.JTable swapMessagesTable;
    private javax.swing.JScrollPane swapNetworkPane;
    private javax.swing.JSplitPane topBottomSplitPane;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

}
