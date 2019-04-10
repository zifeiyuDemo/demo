package com.example.demo.mode.Decorator.interfaces;

/**
 * 烤串调味 抽象类
 */
public abstract class FlavorMutton implements MuttonShashlik {

    private MuttonShashlik muttonShashlik;

    public FlavorMutton(MuttonShashlik muttonShashlik){
        super();
        System.out.println("abstract FlavorMutton");
        this.muttonShashlik = muttonShashlik;
    }

    // 切肉
    public void cutMutton(){
        System.out.println("abstract cutMutton");
        this.muttonShashlik.cutMutton();
    }

    // 串串
    public void assembleMutton(){
        System.out.println("abstract assembleMutton");
        this.muttonShashlik.assembleMutton();
    }

    // 调味
    public void setFlavor(){
        this.muttonShashlik.setFlavor();
        System.out.println("abstract setFlavor");
    }

    // 制作
    public void process(){
        cutMutton();
        assembleMutton();
        setFlavor();
        System.out.println("abstract 开始烤制...");
    }

}
