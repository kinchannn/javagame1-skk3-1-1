import java.awt.image.*;
import java.io.*;

/**
 * 敵９
 */
public class KSpriteT09 extends KSpriteT00 implements KConstant {

	private	final	int	PHASE_1	= 1;
	private	final	int	PHASE_2	= 2;

	/** フェーズ */
	private		int		phase	= PHASE_1;

	/** X座標 */
	private		float	floatX	= 0;

	/** X方向移動量 */
	private		float	mX		= 0;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT09 = null;

		imageT09 = KImage.getImage("image/imageT09.gif");

		KSpriteT09.setImage(KSpriteT09.class, imageT09);

	} // end initImage

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param intX スプライトグループで表示位置を決定する
	 */
	public KSpriteT09(KPanel panel, int intX){

		super(panel);

		this.intX = intX;

		// 画面下から出現させる
		this.intY = HEIGHT;

	} // end KSpriteT09

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

		// フェーズ１の場合、
		if(phase == PHASE_1){

			// 前進
			intY = intY - 4;

			// 上まで登った場合、
			if(super.getY() <= 0){

				// フェーズ変更
				phase = PHASE_2;

				// X方向移動量計算
				floatX = (float)super.getX();

				mX = (int)(Math.random() * 10) * ((super.getX() == 0)?1: -1);

			} // end if 上まで登った場合

		// フェーズ２の場合、
		}else{

			// 前進
			intY = intY + 6;

			floatX = floatX + mX;

			// 内部変数のintXにキャストして設定
			intX = (int)floatX;

			// 画面の外に出た場合、
			if(intY > HEIGHT){
				// スプライトを消す
				super.removeSprite();
			}

		} // end if フェーズ２の場合

	} // end run

	/**
	 * 爆発
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(200);

		super.bomb();

	} // end bomb

}
