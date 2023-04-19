package front_end;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class tocaTrilhaSonora extends Thread{
	
	public void run() {
			TrilhaSonora();
	}
	public void TrilhaSonora() {
		URL url = getClass().getResource("/resources/trilha_sonora_naruto.wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.loop();
	}
	

}
