import java.awt.image.*;
import java.io.*;

/**
 * 敵ミサイル
 */
public class KSpriteT9A extends KSprite implements KConstant {

	/** 時間 */
	private		int		time 		= 0;

	/** 移動量 */
	private		int		mY			= 16;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT9A = null;

		imageT9A = KImage.getImage("image/imageT9A.gif");

		KSpriteT9A.setImage(KSpriteT9A.class, imageT9A);

	} // end initImage

	/**
	 * コンストラクタ
	 * <pre>
	 * ビームです。
	 * </pre>
	 */
	public KSpriteT9A(KPanel panel, KSprite sprite){

		super(panel);

		// 位置を保持
		intX = sprite.getX() + sprite.getWidth() / 2 - 2;
		intY = sprite.getY() + sprite.getHeight();

	} // end KSpriteT9A

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		time++;

		if(time < 15){
			// 移動
			intY = intY + 1;

		}else{
			// 移動
			intY = intY + mY;
		}

		if(intY > HEIGHT){
			super.removeSprite();
		}

	} // end run

}
