package com.wm.demo.patterns.build.factorySimple;

public class MusicBoxDemo {
    
    public static void main(String[] args) throws Exception {
       // playMusicBox(MusicBoxFactory.createMusicBox("PianoBox"));
       // playMusicBox(MusicBoxFactory.createMusicBox("ViolinBox"));
        
    	 //利用工厂模式，客户端只需要对工厂指定你要创建的对象的名字（参数），工厂就可以根据你指定的参数动态
        //创建不同的对象。当然，这些不同的对象就有不同的表现（在本例中通过play表示）
        playMusicBox(MusicBoxFactory.createMusicBox("SimpleFactory.PianoBox"));
        playMusicBox(MusicBoxFactory.createMusicBox("SimpleFactory.ViolinBox"));
    }
    
    public static void playMusicBox(IMusicBox musicBox) {
        musicBox.play();
    }
}