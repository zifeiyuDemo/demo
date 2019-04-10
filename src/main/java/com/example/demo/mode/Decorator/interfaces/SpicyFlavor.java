package com.example.demo.mode.Decorator.interfaces;

/**
 * 麻辣的
 */
public class SpicyFlavor extends FlavorMutton {

    public SpicyFlavor(MuttonShashlik muttonShashlik){
        super(muttonShashlik);
    }

    public void addFlavor(){
        System.out.println("多放点辣椒");
    }

    @Override
    public void setFlavor(){
        this.addFlavor();
        super.setFlavor();
    }
}
