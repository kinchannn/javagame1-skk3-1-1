import java.awt.*;
import java.io.*;

import java.net.*;
import javax.sound.sampled.*;

import javax.swing.*;

/**
 * Wave
 * <pre>
 * Wave演奏を制御します。
 * </pre>
 */
public class KSoundWave {

	/** クリップ */
	private		Clip		clip		= null;

	/** 繰り返し */
	private		boolean		flgLoop		= true;

	/**
	 * コンストラクタ
	 * <pre>
	 * Waveオブジェクトを生成します。
	 * </pre>
	 * @param obj パスを決めるオブジェクト
	 * @param fileName ファイル名
	 * @param flgLoop true：繰り返す ／ false：繰り返さない
	 */
	public KSoundWave(Object obj, String fileName, boolean flgLoop){

		try{

			if(obj == null){
				obj = this;
			}

			// ストリーム取得
			InputStream is = obj.getClass().getResourceAsStream(fileName);

			// オーディオ入力ストリームを取得
			AudioInputStream sound = AudioSystem.getAudioInputStream(new BufferedInputStream(is));

			// サウンド・データのオーディオ形式を取得
			AudioFormat format = sound.getFormat();

			// データ・ラインの情報オブジェクトを構築
			DataLine.Info di = new DataLine.Info(Clip.class, format);

			// ラインを取得
			this.clip = (Clip)AudioSystem.getLine(di);

			// クリップを開く
			clip.open(sound);

			// 繰り返し設定
			this.flgLoop = flgLoop;

		}catch(UnsupportedAudioFileException ex){
			ex.printStackTrace();
			return;
		}catch(IOException ex){
			ex.printStackTrace();
			return;
		}catch(LineUnavailableException ex){
			ex.printStackTrace();
			return;
		}

	} // end KSoundWave

	/**
	 * 演奏スタート
	 */
	public void start(){

		// ポジションを戻す
		clip.setFramePosition(0);

		// スタート
		clip.start();

		// 繰り返し設定
		if(this.flgLoop){
			clip.loop(1000);
		}

	}

	/**
	 * 演奏ストップ
	 */
	public void stop(){

		// 実行中の場合、
		if(clip.isActive()){
			// 停止
			clip.stop();
		}
	}

}

