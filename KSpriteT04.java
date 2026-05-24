import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 敵４
 */
public class KSpriteT04 extends KSpriteT00 implements KConstant {

	/** フェーズ：移動スタートモード */
	private final int PHASE_START = 0;

	/** フェーズ：追いかけモード */
	private final int PHASE_CHASE = 1;

	/** フェーズ */
	private int phase = PHASE_START;

	/** X方向移動量 */
	private int mx = 0;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT04_00 = null;
		BufferedImage imageT04_01 = null;
		BufferedImage imageT04_02 = null;

		imageT04_00 = KImage.getImage("image/imageT04_00.gif");
		imageT04_01 = KImage.getImage("image/imageT04_01.gif");
		imageT04_02 = KImage.getImage("image/imageT04_02.gif");

		KSpriteT04.setImage(KSpriteT04.class, new BufferedImage[]{
			imageT04_00,
			imageT04_01,
			imageT04_02
		});

	} // end initImage

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 */
	public KSpriteT04(KPanel panel){

		super(panel);

		// X位置：編隊ポジションを設定
		intX = (int)(Math.random() * (WIDTH - getWidth()));

		intY = -getHeight();

	} // end KSpriteT04

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
		switch(phase){

			// 移動スタートモード
			case PHASE_START:

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
				KSprite sprite = spriteLst.get(0);

				// 自機と並んだ場合、
				if(intY > sprite.getY()){

					// フェーズを追いかけにする
					phase = PHASE_CHASE;

					// 自機が右にいる場合、
					if(intX < sprite.getX()){

						// 右へ移動
						mx = 5;

						// イメージを変更する
						setImage(KSpriteT04.class, 1);

					// 上記以外の場合、
					}else{

						// 左へ移動
						mx = -5;

						// イメージを変更する
						setImage(KSpriteT04.class, 2);

					} // end if

				} // end if 自機と並んだ場合

				// ブレイク
				break;

			// 追いかけモード
			case PHASE_CHASE:

				// X方向に移動する
				intX = intX + mx;

				// 画面の外に出た場合、
				if(intX > WIDTH){
					// スプライトを消す
					super.removeSprite();
				}

				// 画面の外に出た場合、
				if(intX < 0){
					// スプライトを消す
					super.removeSprite();
				}

			default:
				// ブレイク
				break;

		} // end switch フェーズにより、処理を分ける

	} // end run

	/**
	 * 爆発
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(100);

		super.bomb();

	} // end bomb

}
