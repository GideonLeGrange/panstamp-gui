/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.legrange.panstamp.gui.tree;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import me.legrange.panstamp.Endpoint;
import me.legrange.panstamp.GatewayException;

/**
 *
 * @author gideon
 */
public class SWAPNodeRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        if (value instanceof SWAPNode) {
            try {
                SWAPNode node = (SWAPNode) value;
                switch (node.getType()) {
                    case ENDPOINT:
                        return renderEndpoint((EndpointNode) node);
                    case REGISTER:
                        return renderRegister((RegisterNode) node);
                    case PANSTAMP:
                        return renderPanStamp((PanStampNode) node);
                    case GATEWAY:
                        return renderGateway((GatewayNode) node);
                    case WORLD : 
                        return renderWorld((WorldNode)node);
                }
            } catch (GatewayException ex) {
                Logger.getLogger(SWAPNodeRenderer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
    }

    private Component renderEndpoint(EndpointNode epn) throws GatewayException {
        return new JLabel(String.format("%s = %s", epn.getEndpoint().getName(), formatValue(epn.getEndpoint())), getIcon(ICON_ENDPOINT), JLabel.LEADING);
    }

    private Component renderRegister(RegisterNode rn) {
        return new JLabel("" + rn.getRegister().getId(), getIcon(ICON_REGISTER), JLabel.LEADING);

    }

    private Component renderPanStamp(PanStampNode psn) {
        return new JLabel("" + psn.getPanStamp().getAddress(), getIcon(ICON_DEVICE), JLabel.LEADING);

    }

    private Component renderGateway(GatewayNode gn) {
        return new JLabel("Network", getIcon(ICON_NETWORK), JLabel.LEADING);
    }

    private Component renderWorld(WorldNode wn) {
        return new JLabel("", getIcon(ICON_WORLD), JLabel.LEADING);
    }

    private String formatValue(Endpoint ep) throws GatewayException {
        List<String> units = ep.getUnits();
        String unit = "";
        Object val = ep.getValue();
        if (!units.isEmpty()) {
            unit = units.get(0);
            val = ep.getValue(unit);
        }
        if (val instanceof Double) {
            return String.format("%.1f %s", ((Double) val), unit);
        }
        if (val instanceof Boolean) {
            return ((Boolean) val) ? "on" : "off";
        }
        return String.format("%s%s", val.toString(), unit);
    }
    
    private Icon getIcon(String name)  {
        ImageIcon ico = icons.get(name);
        if (ico == null) {
                try {
                     ico = new ImageIcon(ImageIO.read(ClassLoader.getSystemResourceAsStream("images/" + name)));
/*                    Image image = ico.getImage(); // transform it 
                    Image newimg = image.getScaledInstance(16, 16,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    ico  = new ImageIcon(newimg);  // transform it back */
                } catch (IOException ex) {
                    Logger.getLogger(SWAPNodeRenderer.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                icons.put(name, ico);
            }
        
    return ico;
    }
    
    private static final String ICON_WORLD = "world16x16.png";
    private static final String ICON_NETWORK = "network16x16.png";
    private static final String ICON_DEVICE = "device16x16.png";
    private static final String ICON_REGISTER = "register16x16.png";
    private static final String ICON_ENDPOINT = "endpoint16x16.png";
    private final Map<String, ImageIcon> icons = new HashMap<>();
    
}