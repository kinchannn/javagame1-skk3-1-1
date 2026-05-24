import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 地上物 64ドット 回転物
 */
public class KSpriteG61 extends KSpriteG00 implements KConstant {

	private		int		time		= 0;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageG61_00 = null;
		BufferedImage imageG61_01 = null;
		BufferedImage imageG61_02 = null;
		BufferedImage imageG61_03 = null;

		imageG61_00 = KImage.getImage("image/imageG61_00.gif");
		imageG61_01 = KImage.getImage("image/imageG61_01.gif");
		imageG61_02 = KImage.getImage("image/imageG61_02.gif");
		imageG61_03 = KImage.getImage("image/imageG61_03.gif");

		KSpriteG61.setImage(KSpriteG61.class, new BufferedImage[]{
			imageG61_00,
			imageG61_01,
			imageG61_02,
			imageG61_03
		});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteG61(KPanel panel, int intX){

		super(panel);

		this.intX = intX;
		intY = -128;

	} // end KSpriteG61

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

		// 0.1秒単位に
		if(time % 6 == 0){

			// イメージ計算
			int image = (time / 6) % 4;

			// イメージを変更する
			setImage(image);

		}

	} // end run

	/**
	 * 爆発
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(100);

		super.bomb();

	} // end bomb

}
