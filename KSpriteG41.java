import java.awt.image.*;
import java.io.*;

/**
 * Z90
 */
public class KSpriteG41 extends KSpriteG00 implements KConstant {

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageG41 = null;

		imageG41 = KImage.getImage("image/imageG41.gif");

		KSpriteG41.setImage(KSpriteG41.class, imageG41);

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteG41(KPanel panel, int intX){

		super(panel);

		this.intX = intX;
		intY = -128;

	} // end KSpriteG41

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		// スーパークラスを呼び出す
		// 移動はスーパークラスで制御
		super.run();

	}

	/**
	 * 爆発
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(100);

		super.bomb();

	} // end bomb

}
