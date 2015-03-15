package me.legrange.panstamp.gui.model.tree;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.legrange.panstamp.Endpoint;
import me.legrange.panstamp.GatewayException;
import me.legrange.panstamp.Parameter;
import me.legrange.panstamp.Register;
import me.legrange.panstamp.RegisterListener;

/**
 *
 * @author gideon
 */
public class RegisterNode extends NetworkTreeNode<Register, Endpoint> implements RegisterListener {

    public RegisterNode(Register reg) {
        super(reg);
    }

    public Register getRegister() {
        return (Register) getUserObject();
    }

    @Override
    public String toString() {
        return String.format("Register %d: %s", getRegister().getId(), getRegister().getName());
    }

    @Override
    protected synchronized void start() {
        getRegister().addListener(this);
        for (Endpoint ep : getRegister().getEndpoints()) {
            EndpointNode epn = new EndpointNode(ep);
            addToTree(epn, this);
            epn.start();
        }
    }

    @Override
    protected void stop() {
        getRegister().removeListener(this);
        super.stop();
    }

    void update(Register reg) {
        if (reg.getEndpoints().size() != getRegister().getEndpoints().size()) {
            
            for (Endpoint ep : getRegister().getEndpoints()) {
                EndpointNode epn = new EndpointNode(ep);
                addToTree(epn, this);
                epn.start();
            }
            reload();
        }
        setUserObject(reg);
    }

    @Override
    public Type getType() {
        return Type.REGISTER;
    }

    @Override
    public void valueReceived(Register reg, byte[] value) {
    }

    @Override
    public void valueSet(Register reg, byte[] value) {
        
    }
    
 
    @Override
    public void endpointAdded(Register reg, Endpoint ep) {
        addChild(ep);
        reload();
    }

    @Override
    public void parameterAdded(Register reg, Parameter par) {
    }

    @Override
    void addChild(Endpoint ep) {
        EndpointNode epn = new EndpointNode(ep);
        addToTree(epn, this);
        epn.start();

    }
}
