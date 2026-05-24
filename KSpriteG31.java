import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 地上物 32ドット 破壊可能
 */
public class KSpriteG31 extends KSpriteG00 implements KConstant {

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageG31 = null;
		BufferedImage imageG32_0 = null;
		BufferedImage imageG32_1 = null;
		BufferedImage imageG32_2 = null;
		BufferedImage imageG32_3 = null;
		BufferedImage imageG33 = null;
		BufferedImage imageG34 = null;
		BufferedImage imageG35 = null;
		BufferedImage imageG36 = null;

		imageG31 = KImage.getImage("image/imageG31.gif");
		imageG32_0 = KImage.getImage("image/imageG32_0.gif");
		imageG32_1 = KImage.getImage("image/imageG32_1.gif");
		imageG32_2 = KImage.getImage("image/imageG32_2.gif");
		imageG32_3 = KImage.getImage("image/imageG32_3.gif");
		imageG33 = KImage.getImage("image/imageG33.gif");
		imageG34 = KImage.getImage("image/imageG34.gif");
		imageG35 = KImage.getImage("image/imageG35.gif");
		imageG36 = KImage.getImage("image/imageG36.gif");

		KSpriteG31.setImage(KSpriteG31.class, new BufferedImage[]{
			imageG31,
			imageG32_0,
			imageG32_1,
			imageG32_2,
			imageG32_3,
			imageG33,
			imageG34,
			imageG35,
			imageG36
		});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteG31(KPanel panel, int intX, int image){

		super(panel);

		int tekiImage = -1;

		tekiImage = (image == G31  )? 0: tekiImage;
		tekiImage = (image == G32_0)? 1: tekiImage;
		tekiImage = (image == G32_1)? 2: tekiImage;
		tekiImage = (image == G32_2)? 3: tekiImage;
		tekiImage = (image == G32_3)? 4: tekiImage;
		tekiImage = (image == G33  )? 5: tekiImage;
		tekiImage = (image == G34  )? 6: tekiImage;
		tekiImage = (image == G35  )? 7: tekiImage;
		tekiImage = (image == G36  )? 8: tekiImage;

		setImage(tekiImage);

		this.intX = intX;
		intY = -128;

	} // end KSpriteG31

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

	} // end run

	/**
	 * 爆発
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(50);

		super.bomb();

	} // end bomb

}
