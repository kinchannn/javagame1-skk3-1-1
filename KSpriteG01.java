import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 地上物 32ドット 破壊可能 ビーム発射
 */
public class KSpriteG01 extends KSpriteG00 implements KConstant {

	private		int		time		= 0;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageG01_00 = null;
		BufferedImage imageG01_01 = null;
		BufferedImage imageG01_02 = null;
		BufferedImage imageG01_03 = null;
		BufferedImage imageG01_04 = null;
		BufferedImage imageG01_05 = null;
		BufferedImage imageG01_06 = null;

		imageG01_00 = KImage.getImage("image/imageG01_00.gif");
		imageG01_01 = KImage.getImage("image/imageG01_01.gif");
		imageG01_02 = KImage.getImage("image/imageG01_02.gif");
		imageG01_03 = KImage.getImage("image/imageG01_03.gif");
		imageG01_04 = KImage.getImage("image/imageG01_04.gif");
		imageG01_05 = KImage.getImage("image/imageG01_05.gif");
		imageG01_06 = KImage.getImage("image/imageG01_06.gif");

		KSpriteG01.setImage(KSpriteG01.class, new BufferedImage[]{
			imageG01_00,
			imageG01_01,
			imageG01_02,
			imageG01_03,
			imageG01_04,
			imageG01_05,
			imageG01_06
		});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteG01(KPanel panel, int intX){

		super(panel);

		this.intX = intX;
		intY = -128;

	} // end KSpriteG01

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

		// 爆発している場合、
		if(super.isBomb()){
			// リターン
			return;
		}

		// 時間＋１
		time++;

		// 0.5秒経ったら、
		if(time >= 30){

			// イメージ計算
			int image = (time - 30) / 10;
			image = (image < 6)?image: 6;

			// イメージを変更する
			setImage(image);

		}

		// 1.5秒
		if(time == 90){

			KSpriteT99 kSpriteT99 = new KSpriteT99(super.getKPanel(), this, 3);
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT99);

		}

	} // end run

	/**
	 * 当たり判定
	 * @return true：する ／ false：しない
	 */
	public boolean isHanteiAtari(){

		// 時間がきた場合、
		if(time > 90){

			// する
			return true;

		}

		// しない
		return false;

	} // end isHanteiAtari

	/**
	 * 爆発
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(100);

		super.bomb();

	} // end bomb

}
