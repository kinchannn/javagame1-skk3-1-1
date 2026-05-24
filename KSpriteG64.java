import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * シャチホコ
 */
public class KSpriteG64 extends KSpriteG00 implements KConstant {

	/** 被弾数 */
	private		int					hidan		= 0;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageG00 = null;
		BufferedImage imageG64 = null;

		imageG00 = KImage.getImage("image/imageG64_0.gif");
		imageG64 = KImage.getImage("image/imageG64_1.gif");

		KSpriteG64.setImage(KSpriteG64.class, new BufferedImage[]{
			imageG00,
			imageG64
		});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteG64(KPanel panel, int intX){

		super(panel);

		this.intX = intX;
		intY = -128;

	} // end KSpriteG64

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

		// 被弾数＋１
		hidan++;

		// 被弾数が10発の場合、
		if(hidan == 10){

			// シャチホコ出現
			setImage(1);

			// シャチホコ出現
			((KCtrlSKK)panel.getKCtrl()).appearSYATIHOKO();

		// 被弾数が25発の場合、
		}else if(hidan >= 25){

			// １０万点ボーナス
			((KCtrlSKK)panel.getKCtrl()).addScore(100000);

			// シャチホコ破壊
			((KCtrlSKK)panel.getKCtrl()).bombSYATIHOKO();

			super.bomb();

		// 上記以外、
		}else{

			// 地上物耐える音スタート
			((KCtrlSKK)panel.getKCtrl()).startWaveJimenTaeru();

		} // end if

	} // end bomb

}
