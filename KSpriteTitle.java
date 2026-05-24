import java.awt.*;
import java.awt.image.*;
import java.io.*;

/**
 * タイトル
 */
public class KSpriteTitle extends KSprite {

	/** フォント */
	private		Font		font				= new Font("Dialog", Font.ITALIC, 48);

	/** 前景色 */
	private		Color		colorForeground		= Color.yellow;

	/** 時間 */
	private		int			time				= 0;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageTitle = null;

		imageTitle = KImage.getImage("image/imageTitle.gif");

		KSpriteTitle.setImage(KSpriteTitle.class, imageTitle);

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteTitle(KPanel panel){

		super(panel);

	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		// 時間＋１
		time++;

		// 時間計算
		time = (time > 1800)?0: time;

	}

	/**
	 * スプライト描画
	 * <pre>
	 * 表示の必要があれば実行される。
	 * </pre>
	 */
	public void paint(Graphics g){

		// 3.2秒
		if(time < 192){

			// 何もしない

		// 3.3秒
		}else if(time < 198){

			// 3.2秒
			if(time == 192){

				// 効果音をスタート
				((KCtrlSKK)panel.getKCtrl()).startWaveAlpha();

			}

			// 時間
			int time1 = time - 192;

			// 色
			g.setColor(this.colorForeground);

			// 位置
			int intY00 = 200 - time1 * 25;
			int intY01 = time1 * 20;
			int intY10 = 200;
			int intY11 = time1 * 5;

			// 塗りつぶし
			g.fillRect((int)(424 * panel.getRatioWidth()), (int)(intY00 * panel.getRatioHeight()), (int)(144 * panel.getRatioWidth()), (int)(intY01 * panel.getRatioHeight()));
			g.fillRect((int)(424 * panel.getRatioWidth()), (int)(intY10 * panel.getRatioHeight()), (int)(144 * panel.getRatioWidth()), (int)(intY11 * panel.getRatioHeight()));

		// 3.4秒
		}else if(time < 204){

			// 時間
			int time1 = time - 198;

			// 色
			g.setColor(this.colorForeground);

			// 位置
			int intY00 = 80;
			int intY01 = (6 - time1) * 25;
			int intY10 = 200 + time1 * 5;
			int intY11 = (6 - time1) * 5;

			// 塗りつぶし
			g.fillRect((int)(424 * panel.getRatioWidth()), (int)(intY00 * panel.getRatioHeight()), (int)(144 * panel.getRatioWidth()), (int)(intY01 * panel.getRatioHeight()));
			g.fillRect((int)(424 * panel.getRatioWidth()), (int)(intY10 * panel.getRatioHeight()), (int)(144 * panel.getRatioWidth()), (int)(intY11 * panel.getRatioHeight()));

		} // end if

		// 親クラスを呼び出す
		super.paint(g);

		// 2秒
		if(time < 120){

			// 何もしない

		// 3秒
		}else if(time < 180){

			// フォント
			font = new Font("Dialog", Font.ITALIC, (int)(48 *  panel.getRatioWidth()));
			g.setFont(font);

			// 色
			g.setColor(this.colorForeground);

			// 位置
			int intY = 0;

			// 交互に表示
			if(time % 4 < 2){
				// 位置を計算
				intY = (int)((time - 120) * 3.5);
			// 交互に表示
			}else{
				// 位置を計算
				intY = 800 - (int)((time - 120) * 10);
			}

			// 文字列を表示
			g.drawString("ακι２", (int)(424 * panel.getRatioWidth()), (int)(intY * panel.getRatioHeight()));

		} // end if

	} // end paint

}
