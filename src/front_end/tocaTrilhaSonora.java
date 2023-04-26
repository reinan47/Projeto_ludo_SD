package front_end;

import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class tocaTrilhaSonora extends Thread {

	private Clip back_sound;

	public void run() {
		try {
			TrilhaSonora();
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void stopSound() {
		back_sound.stop();
	}
	public void startSound() {
		back_sound.start();
	}

	public void TrilhaSonora() throws UnsupportedAudioFileException, IOException {

		try {

			back_sound = AudioSystem.getClip();
			back_sound.open(AudioSystem.getAudioInputStream(
					getClass().getClassLoader().getResource("trilha_sonora_naruto.wav")));
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
			// TODO Auto-generated catch block
			((Throwable) e1).printStackTrace();
		}

		back_sound.setMicrosecondPosition(0);
		back_sound.loop(20);
		back_sound.start();

	}

}
