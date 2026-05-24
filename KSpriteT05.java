import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 敵５
 */
public class KSpriteT05 extends KSpriteT00 implements KConstant {

	//
	// 敵をいい感じで移動させるために、いろいろと計算している
	//
	private	final	int			SPRITE_WIDTH = 32;

	private final	int			MARGIN = 48;

	private final	int			RANGE = (WIDTH - MARGIN * 2) / 2;

	private final	int			CENTER = WIDTH / 2 - SPRITE_WIDTH;

	private			boolean		flgCourse = false;

	/** ビーム発射位置 */
	private			int			timeBeam	= -1;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT05_00 = null;
		BufferedImage imageT05_01 = null;
		BufferedImage imageT05_02 = null;
		BufferedImage imageT05_03 = null;

		imageT05_00 = KImage.getImage("image/imageT05_00.gif");
		imageT05_01 = KImage.getImage("image/imageT05_01.gif");
		imageT05_02 = KImage.getImage("image/imageT05_02.gif");
		imageT05_03 = KImage.getImage("image/imageT05_03.gif");

		KSpriteT05.setImage(KSpriteT05.class, new BufferedImage[]{imageT05_00, imageT05_01, imageT05_02, imageT05_03});

	} // end initImage

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param storyParam ビーム発射位置
	 */
	public KSpriteT05(KPanel panel, String storyParam){

		super(panel);

		// スプライト一覧取得
		ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_JIBUN);

		// 自機を取得
		KSprite sprite = spriteLst.get(0);

		// 自機が左側にいる場合、
		if(sprite.getX() < WIDTH / 2){
			// コース変更
			flgCourse = true;
		}

		intY = -getHeight();

		// バグ対応
		// 設定しないと、一番左でビームを出すと、やっつけれる時がある。
		intX = -100;

		// ビーム発射位置が設定されている場合、
		if(storyParam != null && !storyParam.equals("-1")){
			// ビーム発射位置を保存
			timeBeam = Integer.parseInt(storyParam);
		}

	} // end KSpriteT05

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		// 親クラスを実行する
		super.run();

		// 前進
		intY = intY + 1;

		// 画面の外に出た場合、
		if(intY > HEIGHT){
			// スプライトを消す
			super.removeSprite();
		}

		// X方向の移動
		// Y方向に、円の移動量を計算してX方向の位置を計算
		// もっと簡単な計算方法があるかもしれない。疑似的な計算でもいいと思う。
		// ようはうまく動けばいいと思う。
		intX = CENTER + (int)(Math.sin(Math.toRadians((double)((intY * 2 + (flgCourse?180: 0)) % 360))) * RANGE);

		// 生きている場合、
		if(!isBomb()){

			// 一定量進んだ場合、
			if(intY % 6 == 0){
				// イメージを変更する
				// くるくる回ってる感じを出す
				setImage(KSpriteT05.class, Math.abs(intY / 6) % 4);
			}

			// ビームを発射する場合、
			if(timeBeam != -1 && intY % timeBeam == (timeBeam - 1)){

				// ビーム発射
				KSpriteT99 kSpriteT99 = new KSpriteT99(super.getKPanel(), this, 6);
				super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT99);

			}

		} // end if 生きている場合

	} // end run

	/**
	 * 爆発
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(100);

		super.bomb();

	} // end bomb

}
