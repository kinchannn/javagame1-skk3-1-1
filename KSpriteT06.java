import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 敵６
 */
public class KSpriteT06 extends KSpriteT00 implements KConstant {

	/** ビーム発射フラグ */
	private		boolean		flgBeam		= false;

	/** フェーズ */
	private		boolean		flgPhase	= false;

	/** X方向移動量 */
	private		int			mX 		= 0;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT06 = null;

		imageT06 = KImage.getImage("image/imageT06.gif");

		KSpriteT06.setImage(KSpriteT06.class, imageT06);

	} // end initImage

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param storyParam ビーム発射
	 */
	public KSpriteT06(KPanel panel, String storyParam){

		super(panel);

		// X位置：編隊ポジションを設定
		intX = (int)(Math.random() * (WIDTH - getWidth()));

		intY = -getHeight();

		// ビーム発射位置が設定されている場合、
		if(storyParam != null && storyParam.equals("true")){
			// ビーム発射位置を保存
			flgBeam = true;
		}

	} // end KSpriteT06

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 親クラスを実行する
		super.run();

		// フェーズにより、処理を分ける
		if(!flgPhase){

			// 前進
			intY = intY + 4;

			// 画面の外に出た場合、
			if(intY > HEIGHT){
				// スプライトを消す
				super.removeSprite();
			}

			// スプライト一覧取得
			ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_JIBUN);

			// 自機を取得
			KSprite spriteShip = spriteLst.get(0);

			// 1/2を過ぎた場合、
			if(super.getY() >= spriteShip.getY() / 2){

				// 方向変え
				flgPhase = true;

				// 位置を設定
				int dx = spriteShip.getX() - intX;

				// X方向の速さを取得
				if(dx > 100){
					mX = 3;
				}else if(dx < -100){
					mX = -3;
				}else{
					mX = 0;
				}

				// ビームを発射する場合、
				if(flgBeam){

					// ビーム発射
					flgBeam = true;

					KSpriteT99 kSpriteT99 = new KSpriteT99(super.getKPanel(), this, 6);
					super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT99);

				} // end if  ビームを発射する場合

			} // end if 1/2を過ぎた場合

		// フェーズにより、処理を分ける
		}else{

			// 前進
			intY = intY + 6;

			intX = intX + mX;

			// 画面の外に出た場合、
			if(intY > HEIGHT){
				// スプライトを消す
				super.removeSprite();
			}

		} // end if フェーズにより、処理を分ける

	} // end run

	/**
	 * 爆発
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(200);

		super.bomb();

	} // end bomb

}
