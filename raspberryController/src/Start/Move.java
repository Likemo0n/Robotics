/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

/**
 *
 * @author pi
 */

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class Move {
    GpioController gpio=GpioFactory.getInstance();
            
    GpioPinDigitalOutput M1O1=gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28);
    GpioPinDigitalOutput M1O2=gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29);
    
    GpioPinDigitalOutput M2O1=gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24);
    GpioPinDigitalOutput M2O2=gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25);
    
    GpioPinDigitalOutput M3O1=gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22);
    GpioPinDigitalOutput M3O2=gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23);
    
    GpioPinDigitalOutput M4O1=gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
    GpioPinDigitalOutput M4O2=gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03);
    
    GpioPinDigitalInput SGU=gpio.provisionDigitalInputPin(RaspiPin.GPIO_04,"SGU",PinPullResistance.PULL_DOWN);
    GpioPinDigitalInput SGD=gpio.provisionDigitalInputPin(RaspiPin.GPIO_05,"SGD",PinPullResistance.PULL_DOWN);

    
    public void waitSGU(){
        while(SGU.getState().isLow()){
            
        }
    }
    public void waitSGD(){
        while(SGD.getState().isLow()){
            
        }
    }
    //myButton.addListener(new GpioUsageExampleListener());
    
    public void forward(){
        M1O1.setState(true);
        M1O2.setState(false);
        
        M2O1.setState(false);
        M2O2.setState(true);
        System.out.println("forward");
    }
    public void back(){
        M1O1.setState(false);
        M1O2.setState(true);
        
        M2O1.setState(true);
        M2O2.setState(false);
        System.out.println("back");
    }
    public void left(){
        M1O1.setState(true);
        M1O2.setState(false);
        
        M2O1.setState(true);
        M2O2.setState(false);
        
        System.out.println("left");
    }
    
    public void right(){
        M1O1.setState(false);
        M1O2.setState(true);
        
        M2O1.setState(false);
        M2O2.setState(true);
        
        
        System.out.println("right");
    }
    
    public void stop(){
        M1O1.setState(false);
        M1O2.setState(false);
        
        M2O1.setState(false);
        M2O2.setState(false);
        
        M3O1.setState(false);
        M3O2.setState(false);
        
        M4O1.setState(false);
        M4O2.setState(false);
        
        System.out.println("stop");
    }
    
    public void handUp(){
        M3O1.setState(true);
        M3O2.setState(false);
        waitSGU();
        stop();
        System.out.println("handUp");
    }
    public void handDown(){
        M3O1.setState(false);
        M3O2.setState(true);
        waitSGD();
        stop();
        System.out.println("handDown");
    }
    public void release(){
        M4O1.setState(true);
        M4O2.setState(false);

        System.out.println("hold");
    }
    public void hold(){
        M4O1.setState(false);
        M4O2.setState(true);
        
        System.out.println("release");
    }
}
