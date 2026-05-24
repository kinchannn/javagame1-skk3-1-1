import java.awt.image.*;
import java.io.*;

/**
 * 敵３
 */
public class KSpriteT03 extends KSpriteT00 implements KConstant {

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT03 = null;

		imageT03 = KImage.getImage("image/imageT03.gif");

		KSpriteT03.setImage(KSpriteT03.class, imageT03);

	} // end initImage

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 */
	public KSpriteT03(KPanel panel){

		super(panel);

		// X位置を設定
		intX = (int)(Math.random() * (WIDTH - getWidth()));

		intY = -getHeight();

	} // end KSpriteT03

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 親クラスを実行する
		super.run();

		// 前進
		intY = intY + 6;

		// 画面の外に出た場合、
		if(intY > HEIGHT){
			// スプライトを消す
			super.removeSprite();
		}

	} // end run

	/**
	 * 爆発
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(50);

		super.bomb();

	} // end bomb

}
