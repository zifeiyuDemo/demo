package com.example.demo.mode.Decorator.interfaces;

/**
 * 咸口的
 */
public class SaltyFlavor extends FlavorMutton {

    public SaltyFlavor(MuttonShashlik muttonShashlik){
        super(muttonShashlik);
    }

    public void addFlavor(){
        System.out.println("多放点盐");
    }

    @Override
    public void setFlavor(){
        this.addFlavor();
        super.setFlavor();
    }

}
