/** 
 * AIM:- To predict the age  using AI 
 * 
 * Front End developed 
 * @author rahul dhar
 * @version 1.01.26.04.2020
 *
 * 
 */
package test;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainEntry {

  public static void main(String[] a) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    JFrame frame = new JFrame();
    String path="Path to the Music directory";
    AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
    Clip clip = AudioSystem.getClip(); 
    clip.open(audioStream); 
    clip.start();
    int result = JOptionPane.showConfirmDialog(frame, "Do you want to switch on Altersdetektor?");
    if(JOptionPane.YES_NO_OPTION == result)
    {
    	path ="E:\\ProjectP1\\service-bell.wav";
    	audioStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
	    clip = AudioSystem.getClip(); 
	    clip.open(audioStream); 
	    clip.start();
    	ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "Path to the  directory in which you have the file" && "python dav.py --face face_detector --age age_detector");
	    builder.redirectErrorStream(true);
	    BufferedReader r = null; 
	    try
	   {
	    Process p = builder.start();
	    r= new BufferedReader(new InputStreamReader(p.getInputStream()));
	   }
	   catch(Exception a1)
	   {}
	   String line="";
        while (true) {
            try {
				line = r.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            if (line == null) { break; }
            System.out.println(line);
        }
    }
     path="Path to the Music directory";
     audioStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
     clip = AudioSystem.getClip(); 
    clip.open(audioStream); 
    clip.start();
	JOptionPane.showMessageDialog(frame,"Thanks for using this software. It has been developed by Rahul Dhar");
  }
}
