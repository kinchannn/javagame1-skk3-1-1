import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 128ドットCPU
 */
public class KSpriteG71 extends KSpriteG00 implements KConstant {

	/** 被弾数 */
	private		int					hidan		= 0;

	/** 敵 */
	private		int					teki		= 0;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageG71 = null;
		BufferedImage imageG72 = null;

		imageG71 = KImage.getImage("image/imageG71.gif");
		imageG72 = KImage.getImage("image/imageG72.gif");

		KSpriteG71.setImage(KSpriteG71.class, new BufferedImage[]{
			imageG71,
			imageG72
		});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteG71(KPanel panel, int intX, int image){

		super(panel);

		int tekiImage = -1;

		tekiImage = (image == G71)? 0: tekiImage;
		tekiImage = (image == G72)? 1: tekiImage;

		setImage(tekiImage);

		this.intX = intX;
		intY = -128;

		this.teki = image;

	} // end KSpriteG71

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

		// MPU かつ 被弾数が16未満の場合、
		// または
		// CPU かつ 被弾数が16未満の場合、
		if(teki == G71 && hidan < 4 || teki == G72 && hidan < 16){

			// 耐える音
			((KCtrlSKK)panel.getKCtrl()).startWaveTekiTaeru();

			// リターン
			return;
		}

		((KCtrlSKK)panel.getKCtrl()).addScore(300);

		super.bomb();

	} // end bomb

}
