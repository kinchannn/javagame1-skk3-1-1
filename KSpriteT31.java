import java.awt.image.*;
import java.io.*;

/**
 * 敵３１
 */
public class KSpriteT31 extends KSpriteT00 implements KConstant {

	/** 場所 */
	private		int					pos			= 0;

	/** 時間 */
	private		int					time		= 0;

	/** フェーズ */
	private		int					phase		= 0;

	/** 被弾数 */
	private		int					hidan		= 0;

	/** スプライトグループ */
	private		KSpriteGroupT31		spriteGroup	= null;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT31_00 = null;
		BufferedImage imageT31_01 = null;
		BufferedImage imageT31_02 = null;
		BufferedImage imageT31_03 = null;

		imageT31_00 = KImage.getImage("image/imageT31_00.gif");
		imageT31_01 = KImage.getImage("image/imageT31_01.gif");
		imageT31_02 = KImage.getImage("image/imageT31_02.gif");
		imageT31_03 = KImage.getImage("image/imageT31_03.gif");

		KSpriteT31.setImage(KSpriteT31.class, new BufferedImage[]{
			imageT31_00,
			imageT31_01,
			imageT31_02,
			imageT31_03
		});

	} // end initImage

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param pos 位置 0から2で指定
	 */
	public KSpriteT31(KPanel panel, int pos, KSpriteGroupT31 spriteGroup){

		super(panel);

		// 位置を保持
		this.pos = pos;

		// スプライトグループを保持
		this.spriteGroup = spriteGroup;

		// 位置を設定
		intX = 300 + (pos - 1) * 100 - getWidth() / 2;
		intY = -getHeight();

	} // end KSpriteT31

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 親クラスを実行する
		super.run();

		// 時間＋１
		time++;

		// 撃墜している場合、
		if(isBomb()){
			// リターン
			return;
		}

		// フェーズ単位で分ける
		switch(phase){

			case 0:

				// 所定位置まで来るまで
				if(intY < (50 + ((pos == 1)?50: 0))){
					// 前進
					intY = intY + 2;
				}

				// 時間が来たら
				if(time >= 150){
					// フェーズを進める
					phase++;
					// 時間を初期化
					time = 0;

					// レーザーT31
					((KCtrlSKK)panel.getKCtrl()).laserT31();

				}

				// ブレイク
				break;

			case 1:
			case 3:
			case 5:
			case 7:

				// ビーム発射タイミングの場合、
				if(time < 120 && time % 2 == 0){

					// ビームを生成
					KSpriteT9A kSpriteT9A = new KSpriteT9A(super.getKPanel(), this);
					// スプライト層に追加
					super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT9A);

				}

				// 時間が来たら
				if(time >= 180){
					// フェーズを進める
					phase++;
					// 時間を初期化
					time = 0;
				}

				// ブレイク
				break;

			case 2:

				// イメージ初期化
				setImage(0);

				// 0.5秒
				if(time <= 30){

					// イメージ変更
					setImage(1);

					// 左に移動
					intX = intX - 3;

				// 1.0秒
				}else if(time >= 60){

					// フェーズを進める
					phase++;
					// 時間を初期化
					time = 0;

					// レーザーT31
					((KCtrlSKK)panel.getKCtrl()).laserT31();

				}

				// ブレイク
				break;

			case 4:

				// イメージ初期化
				setImage(0);

				// 1.0秒
				if(time <= 60){

					// イメージ変更
					setImage(2);

					// 右に移動
					intX = intX + 3;

				// 1.5秒
				}else if(time >= 90){

					// フェーズを進める
					phase++;
					// 時間を初期化
					time = 0;

					// レーザーT31
					((KCtrlSKK)panel.getKCtrl()).laserT31();

				}

				// ブレイク
				break;

			case 6:

				// イメージ初期化
				setImage(0);

				// 0.5秒
				if(time <= 30){

					// イメージ変更
					setImage(1);

					// 左に移動
					intX = intX - 3;

				// 1.0秒
				}else if(time >= 60){

					// フェーズを進める
					phase++;
					// 時間を初期化
					time = 0;

					// レーザーT31
					((KCtrlSKK)panel.getKCtrl()).laserT31();

				}

				// ブレイク
				break;

			case 8:

				// イメージ変更
				setImage(3);

				// 後退
				intY = intY - 4;

				// 画面の外に出た場合、
				if(intY < -100){
					// スプライトグループに削除を通知
					spriteGroup.removeSprite();
					// スプライトを消す
					super.removeSprite();
				}

				// ブレイク
				break;

			default:

				// ブレイク
				break;

		} // end switch フェーズ単位で分ける

	} // end run

	/**
	 * イメージ設定
	 * @imagePhase イメージフェーズ
	 */
	public void setImage(int imagePhase){

		// 爆発している場合、
		if(isBomb()){
			// リターン
			return;
		}

		// スーパークラスを呼び出す
		super.setImage(imagePhase);

	} // end setImage

	/**
	 * 爆発
	 */
	public void bomb(){

		// 被弾数＋１
		hidan++;

		// 被弾数が16未満の場合、
		if(hidan < 16){

			// 耐える音
			((KCtrlSKK)panel.getKCtrl()).startWaveTekiTaeru();

			// リターン
			return;
		}

		((KCtrlSKK)panel.getKCtrl()).addScore(500);

		super.bomb();

		// スプライトグループに削除を通知
		spriteGroup.removeSprite();

	} // end bomb

}
