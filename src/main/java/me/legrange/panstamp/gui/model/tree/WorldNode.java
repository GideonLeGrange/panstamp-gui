package me.legrange.panstamp.gui.model.tree;

import java.util.Enumeration;
import me.legrange.panstamp.Network;

/**
 * The top level node in the  networks tree. 
 * @author gideon
 */
public class WorldNode extends NetworkTreeNode<String, Network> {

    public WorldNode() {
        super("Networks");
    }

    @Override
    public String toString() {
        return "SWAP Networks";
    }

    @Override
    protected void start() {
    }

    @Override
    public Type getType() {
        return Type.WORLD;
    }

    @Override
    public int compareTo(NetworkTreeNode<String, Network> o) {
        return 0;
    }
    
    @Override
    protected void addToTree(NetworkTreeNode childNode, NetworkTreeNode parentNode) {
        tm.addToTree(childNode, parentNode);
    }

    @Override
    void addChild(Network gw) {
        NetworkNode gn = new NetworkNode(gw);
        addToTree(gn, this);
        gn.start();
    }
 
    void removeChild(Network gw) {
        Enumeration<NetworkNode> it = children();
        while (it.hasMoreElements()) {
            NetworkNode gn = it.nextElement();
            if (gn.getNetwork() == gw) {
                remove(gn);
            }
        }
    }

    @Override
    protected void reload(NetworkTreeNode childNode) {
        tm.reload(childNode);
    }


    void setModel(NetworkTreeModel tm) {
        this.tm = tm;
    }

    private NetworkTreeModel tm;


}
