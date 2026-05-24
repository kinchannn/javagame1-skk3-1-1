import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 敵７
 */
public class KSpriteT07 extends KSpriteT00 implements KConstant {

	/** ビーム発射間隔 */
	private		int			timeBeam	= -1;

	/** 回転 */
	private		int			rotate		= 0;

	/** 出現位置 */
	private		boolean		flgLocate	= false;

	/** 時間 */
	private		int			time		= 0;

	/** 画像パターン */
	private		int			pattern		= 0;

	/** X方向移動量 */
	private		int			mX 			= 0;

	/** Y方向移動量 */
	private		int			mY 			= 4;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT07_00 = null;
		BufferedImage imageT07_01 = null;
		BufferedImage imageT07_02 = null;
		BufferedImage imageT07_03 = null;
		BufferedImage imageT07_04 = null;
		BufferedImage imageT07_05 = null;
		BufferedImage imageT07_06 = null;
		BufferedImage imageT07_07 = null;

		imageT07_00 = KImage.getImage("image/imageT07_00.gif");
		imageT07_01 = KImage.getImage("image/imageT07_01.gif");
		imageT07_02 = KImage.getImage("image/imageT07_02.gif");
		imageT07_03 = KImage.getImage("image/imageT07_03.gif");
		imageT07_04 = KImage.getImage("image/imageT07_04.gif");
		imageT07_05 = KImage.getImage("image/imageT07_05.gif");
		imageT07_06 = KImage.getImage("image/imageT07_06.gif");
		imageT07_07 = KImage.getImage("image/imageT07_07.gif");

		KSpriteT07.setImage(KSpriteT07.class, new BufferedImage[]{
			imageT07_00,
			imageT07_01,
			imageT07_02,
			imageT07_03,
			imageT07_04,
			imageT07_05,
			imageT07_06,
			imageT07_07
		});

	} // end initImage

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param storyParam ビーム発射間隔
	 */
	public KSpriteT07(KPanel panel, String storyParam){

		super(panel);

		// スプライト一覧取得
		ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_JIBUN);

		// 自機を取得
		KSprite spriteShip = spriteLst.get(0);

		// 回転初期化
		rotate = (int)(Math.random() * 8);

		// 画面の左側にいる場合、
		if(spriteShip.getX() < WIDTH / 2){
			// 反対側に配置
			flgLocate = true;
			intX = 540;

		// 画面の右側にいる場合、
		}else{
			// 反対側に配置
			flgLocate = false;
			intX = 30;
		}

		intY = -getHeight();

		// ビーム発射間隔が設定されている場合、
		if(storyParam != null){
			// ビーム発射間隔を保存
			timeBeam = Integer.parseInt(storyParam);
		}

	} // end KSpriteT07

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
		intY = intY + mY;
		intX = intX + mX;

		// 生きている場合、
		if(!isBomb()){

			// 移動量を変更
			// 加速していく
			if(intY > 300){
				mX = (!flgLocate)?10: -10;
				mY = 1;
			}else if(intY > 270){
				mX = (!flgLocate)?8: -8;
				mY = 2;
			}else if(intY > 220){
				mX = (!flgLocate)?4: -4;
				mY = 3;
			}else if(intY > 150){
				mX = (!flgLocate)?2: -2;
				mY = 4;
			}

			// 時間＋１
			time++;

			// 回転する
			if(time % 3 == 0){
				rotate++;
				pattern = flgLocate?(Math.abs(rotate / 3) % 8): (7 - Math.abs(rotate / 3) % 8);
				setImage(KSpriteT07.class, pattern);
			}

			// ビーム発射間隔の場合、
			if(timeBeam != -1 && time % timeBeam == 0){

				// ビーム発射
				double mXBeam = 0d;
				double mYBeam = 0d;

				switch(rotate % 8){

					case 0:
						mXBeam = 0d;
						mYBeam = 4d;
						break;
					case 1:
						mXBeam = -2.828d;
						mYBeam = 2.828d;
						break;
					case 2:
						mXBeam = -4d;
						mYBeam = 0d;
						break;
					case 3:
						mXBeam = -2.828d;
						mYBeam = -2.828d;
						break;
					case 4:
						mXBeam = 0d;
						mYBeam = -4d;
						break;
					case 5:
						mXBeam = 2.828d;
						mYBeam = -2.828d;
						break;
					case 6:
						mXBeam = 4d;
						mYBeam = 0d;
						break;
					case 7:
						mXBeam = 2.828d;
						mYBeam = 2.828d;
						break;
					default:
						throw new IllegalStateException("おかしいです");

				} // end switch

				// ビーム発射
				KSpriteT99 kSpriteT99 = new KSpriteT99(super.getKPanel(), this, mXBeam, mYBeam);
				super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT99);

			}

		}

		// 画面の外に出た場合、
		if(intX < -32 || intX > WIDTH || intY > HEIGHT){
			// スプライトを消す
			super.removeSprite();
		}

	} // end run

	/**
	 * 爆発
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(200);

		super.bomb();

	} // end bomb

}
