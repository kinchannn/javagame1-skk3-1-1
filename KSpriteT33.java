import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 敵３３
 */
public class KSpriteT33 extends KSpriteT00 implements KConstant {

	/** 時間 */
	private		int			time		= 0;

	/** 画像パターン */
	private		int			pattern		= 0;

	/** X座標 */
	private		float		floatX		= 0f;

	/** Y座標 */
	private		float		floatY		= 0f;

	/** X方向移動量 */
	private		float		mX 			= 0;

	/** Y方向移動量 */
	private		float		mY 			= 8f;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT33_00 = null;
		BufferedImage imageT33_01 = null;
		BufferedImage imageT33_02 = null;
		BufferedImage imageT33_03 = null;

		imageT33_00 = KImage.getImage("image/imageT33_00.gif");
		imageT33_01 = KImage.getImage("image/imageT33_01.gif");
		imageT33_02 = KImage.getImage("image/imageT33_02.gif");
		imageT33_03 = KImage.getImage("image/imageT33_03.gif");

		KSpriteT33.setImage(KSpriteT33.class, new BufferedImage[]{
			imageT33_00,
			imageT33_01,
			imageT33_02,
			imageT33_03,
			imageT33_02,
			imageT33_01
		});

	} // end initImage

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param storyParam ビーム発射間隔
	 */
	public KSpriteT33(KPanel panel){

		super(panel);

		// スプライト一覧取得
		ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_JIBUN);

		// 自機を取得
		KSprite spriteShip = spriteLst.get(0);

		floatX = (float)((WIDTH - this.getWidth()) * Math.random());
		intX = (int)floatX;

		floatY = (float)-getHeight();
		intY = (int)floatY;

		// 自機を追いかけるように移動量を計算
		mX = (spriteShip.getX() - floatX) / (spriteShip.getY() / mY);
		mX = (mX < -4f)?-4f: mX;
		mX = (mX > 4f)?4f: mX;

	} // end KSpriteT33

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 親クラスを実行する
		super.run();

		// 前進
		floatY = floatY + mY;
		intY = (int)floatY;

		floatX = floatX + mX;
		intX = (int)floatX;

		// 生きている場合、
		if(!isBomb()){

			// 時間＋１
			time++;

			if(time % 4 == 0){

				pattern++;
				pattern = (pattern >= 6)?0: pattern;
				setImage(pattern);

			}

		}

		// 画面の外に出た場合、
		if(intY > HEIGHT){
			// スプライトを消す
			super.removeSprite();
		}

	}

	/**
	 * 爆発
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(100);

		super.bomb();

	} // end bomb

}
