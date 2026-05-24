import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 地面１
 */
public class KSpriteJ01 extends KSpriteJ00 implements KConstant {

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageJ01 = null;
		BufferedImage imageJ02 = null;
		BufferedImage imageJ03 = null;
		BufferedImage imageJ05 = null;
		BufferedImage imageJ06 = null;
		BufferedImage imageJ07 = null;
		BufferedImage imageJ08 = null;
		BufferedImage imageJ11 = null;
		BufferedImage imageJ12 = null;
		BufferedImage imageJ21 = null;
		BufferedImage imageJ22 = null;
		BufferedImage imageK02 = null;
		BufferedImage imageK03 = null;

		imageJ01 = KImage.getImage("image/imageJ01.gif");
		imageJ02 = KImage.getImage("image/imageJ02.gif");
		imageJ03 = KImage.getImage("image/imageJ03.gif");
		imageJ05 = KImage.getImage("image/imageJ05.gif");
		imageJ06 = KImage.getImage("image/imageJ06.gif");
		imageJ07 = KImage.getImage("image/imageJ07.gif");
		imageJ08 = KImage.getImage("image/imageJ08.gif");
		imageJ11 = KImage.getImage("image/imageJ11.gif");
		imageJ12 = KImage.getImage("image/imageJ12.gif");
		imageJ21 = KImage.getImage("image/imageJ21.gif");
		imageJ22 = KImage.getImage("image/imageJ22.gif");

		KSpriteJ01.setImage(KSpriteJ01.class, new BufferedImage[]{
			imageJ01,
			imageJ02,
			imageJ03,
			imageJ05,
			imageJ06,
			imageJ07,
			imageJ08,
			imageJ11,
			imageJ12,
			imageJ21,
			imageJ22
		});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteJ01(KPanel panel, int intX, int image){

		super(panel);

		int tekiImage = -1;

		tekiImage = (image == J01)? 0: tekiImage;
		tekiImage = (image == J02)? 1: tekiImage;
		tekiImage = (image == J03)? 2: tekiImage;
		tekiImage = (image == J05)? 3: tekiImage;
		tekiImage = (image == J06)? 4: tekiImage;
		tekiImage = (image == J07)? 5: tekiImage;
		tekiImage = (image == J08)? 6: tekiImage;
		tekiImage = (image == J11)? 7: tekiImage;
		tekiImage = (image == J12)? 8: tekiImage;
		tekiImage = (image == J21)? 9: tekiImage;
		tekiImage = (image == J22)?10: tekiImage;

		setImage(tekiImage);

		this.intX = intX;
		intY = -128;

	} // end KSpriteJ01

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

}
