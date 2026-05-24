import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 敵ミサイル
 */
public class KSpriteT99 extends KSprite implements KConstant {

	/**
	 * 座標
	 * <pre>
	 * 移動量が小数点以下の場合があるので、doubleへ拡張
	 * </pre>
	 */
	private		double		doubleX = 0d;
	private		double		doubleY = 0d;

	/** 移動量 */
	private		double		mX 		= 0d;
	private		double		mY 		= 0d;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT99 = null;

		imageT99 = KImage.getImage("image/imageT99.gif");

		KSpriteT99.setImage(KSpriteT99.class, imageT99);

	} // end initImage

	/**
	 * コンストラクタ
	 * <pre>
	 * 通常パターンのビームです。
	 * </pre>
	 */
	public KSpriteT99(KPanel panel, KSprite sprite, int speed){

		super(panel);

		// スプライト一覧取得
		ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_JIBUN);

		// 自機を取得
		KSprite spriteShip = spriteLst.get(0);

		// 位置を設定
		doubleX = sprite.getX();
		doubleY = sprite.getY();

		intX = (int)doubleX;
		intY = (int)doubleY;

		int dx = spriteShip.getX() - (int)doubleX;
		int dy = spriteShip.getY() - (int)doubleY;

		// 距離を計算
		double dxdy = Math.sqrt((double)(dx * dx + dy * dy));

		// 到達までの時間を取得
		double time = dxdy / speed;

		// XY方向の速さを取得
		mX = dx / time;
		mY = dy / time;

	} // end KSpriteT99

	/**
	 * コンストラクタ
	 * <pre>
	 * 方向を設定します。
	 * </pre>
	 */
	public KSpriteT99(KPanel panel, KSprite sprite, double mX, double mY){

		super(panel);

		// 位置を設定
		doubleX = sprite.getX();
		doubleY = sprite.getY();

		intX = (int)doubleX;
		intY = (int)doubleY;

		// XY方向の速さを取得
		this.mX = mX;
		this.mY = mY;

	} // end KSpriteT99

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		doubleX = doubleX + mX;
		doubleY = doubleY + mY;

		intX = (int)doubleX;
		intY = (int)doubleY;

		if(intX < 0 || intX > WIDTH || intY < 0 || intY > HEIGHT){
			super.removeSprite();
		}

	} // end run

}
