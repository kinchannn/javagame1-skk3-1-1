import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 地面
 */
public class KSpriteJ31 extends KSpriteJ00 implements KConstant {

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageJ31 = null;
		BufferedImage imageJ32 = null;
		BufferedImage imageJ33 = null;
		BufferedImage imageJ34 = null;
		BufferedImage imageJ35 = null;
		BufferedImage imageJ36 = null;

		imageJ31 = KImage.getImage("image/imageJ31.gif");
		imageJ32 = KImage.getImage("image/imageJ32.gif");
		imageJ33 = KImage.getImage("image/imageJ33.gif");
		imageJ34 = KImage.getImage("image/imageJ34.gif");
		imageJ35 = KImage.getImage("image/imageJ35.gif");
		imageJ36 = KImage.getImage("image/imageJ36.gif");

		KSpriteJ31.setImage(KSpriteJ31.class, new BufferedImage[]{
			imageJ31,
			imageJ32,
			imageJ33,
			imageJ34,
			imageJ35,
			imageJ36
		});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteJ31(KPanel panel, int intX, int image){

		super(panel);

		int tekiImage = -1;

		tekiImage = (image == J31)? 0: tekiImage;
		tekiImage = (image == J32)? 1: tekiImage;
		tekiImage = (image == J33)? 2: tekiImage;
		tekiImage = (image == J34)? 3: tekiImage;
		tekiImage = (image == J35)? 4: tekiImage;
		tekiImage = (image == J36)? 5: tekiImage;

		setImage(tekiImage);

		this.intX = intX;
		intY = -128;

	} // end KSpriteJ31

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
