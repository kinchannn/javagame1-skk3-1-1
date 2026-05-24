import java.awt.image.*;
import java.io.*;

/**
 * 敵ミサイル
 */
public class KSpriteT9B extends KSprite implements KConstant {

	/** 方向 */
	private		String				dir			= null;

	/** 移動量 */
	private		int		mY			= 16;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT9B_UR = null;
		BufferedImage imageT9B_UL = null;

		imageT9B_UR = KImage.getImage("image/imageT9B_UR.gif");
		imageT9B_UL = KImage.getImage("image/imageT9B_UL.gif");

		KSpriteT9B.setImage(KSpriteT9B.class, new BufferedImage[]{imageT9B_UR, imageT9B_UL});

	} // end initImage

	/**
	 * コンストラクタ
	 * <pre>
	 * ビームです。
	 * </pre>
	 * @param panel パネル
	 * @param sprite スプライト
	 * @param dir 方向 UR／UL／DR／DLから指定
	 */
	public KSpriteT9B(KPanel panel, KSprite sprite, String dir){

		super(panel);

		// 方向を保持
		this.dir = dir;

		// 画像の設定
		if("UR".equals(this.dir) || "DL".equals(this.dir)){
			setImage(0);
		}else{
			setImage(1);
		}

		intX = sprite.getX();
		intY = sprite.getY();

		if("UR".equals(this.dir)){
			intX = intX + 40;
			intY = intY - 40;

		}else if("UL".equals(this.dir)){
			intX = intX - 40;
			intY = intY - 40;

		}else if("DR".equals(this.dir)){
			intX = intX + 40;
			intY = intY + 40;

		}else if("DL".equals(this.dir)){
			intX = intX - 40;
			intY = intY + 40;

		} // end if

	} // end KSpriteT9B

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		// 移動
		if("UR".equals(this.dir)){
			intX = intX + 20;
			intY = intY - 20;

		}else if("UL".equals(this.dir)){
			intX = intX - 20;
			intY = intY - 20;

		}else if("DR".equals(this.dir)){
			intX = intX + 20;
			intY = intY + 20;

		}else if("DL".equals(this.dir)){
			intX = intX - 20;
			intY = intY + 20;

		} // end if 移動

		if(intY < -30 || intY > HEIGHT){
			super.removeSprite();
		}

	} // end run

}
