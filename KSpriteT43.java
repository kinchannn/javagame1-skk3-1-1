import java.awt.image.*;
import java.io.*;

/**
 * 敵４３
 */
public class KSpriteT43 extends KSpriteT00 implements KConstant {

	/** 場所 */
	private		int					pos			= 0;

	/** 方向 */
	private		int					hoko		= 0;

	/** 時間 */
	private		int					time		= 0;

	/** フェーズ */
	private		int					phase		= 0;

	/** 被弾数 */
	private		int					hidan		= 0;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT43_00 = null;
		BufferedImage imageT43_01 = null;

		imageT43_00 = KImage.getImage("image/imageT42_00.gif");
		imageT43_01 = KImage.getImage("image/imageT42_01.gif");

		KSpriteT43.setImage(KSpriteT43.class, new BufferedImage[]{
			imageT43_00,
			imageT43_01
		});

	} // end initImage

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param pos 位置 0から7で指定
	 */
	public KSpriteT43(KPanel panel, int pos){

		super(panel);

		// 位置を保持
		this.pos = pos;

		// イメージ初期化
		setImage(hoko);

		intX = -getWidth();
		intY = pos * 64;

	} // end KSpriteT43

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

		// フェーズ単位で分ける
		switch(phase){

			case 0:

				// 右方向
				if(hoko == 0){
					// 表示位置まで
					if(intX < 0){
						// 前進
						intX = intX + 2;
					}

				// 左方向
				}else if(hoko == 1){
					// 表示位置まで
					if(intX > WIDTH - getWidth()){
						// 前進
						intX = intX - 2;
					}

				}

				// 0.5秒
				if(time >= 30){
					// フェーズを進める
					phase++;
					// 時間を初期化
					time = 0;
				}

				// ブレイク
				break;

			case 1:

				// 右方向
				if(hoko == 0){

					// 前進
					intX = intX + 4;

					// 外に出たら、
					if(intX > 600){

						// X位置を修正
						intX = 600;

						// Y位置を修正
						intY = intY + 32;

						// 方向を反対にする
						hoko = 1;

						// イメージ初期化
						setImage(hoko);

						// フェーズを進める
						phase++;

						// 時間を初期化
						time = 0;

					} // end if 外に出たら

				// 左方向
				}else if(hoko == 1){

					// 前進
					intX = intX - 4;

					// 外に出たら、
					if(intX < -getWidth()){

						// X位置を修正
						intX = -getWidth();

						// Y位置を修正
						intY = intY - 32;

						// 方向を反対にする
						hoko = 0;

						// イメージ初期化
						setImage(hoko);

						// フェーズを進める
						phase++;

						// 時間を初期化
						time = 0;

					} // end if 外に出たら

				}

				// ビームを発射する場合、
				if(time == 25 + pos * 3){

					// ビーム発射
					KSpriteT99 kSpriteT99 = new KSpriteT99(super.getKPanel(), this, 2);
					super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT99);

				} // end if  ビームを発射する場合

				// ブレイク
				break;

			case 2:

				// 1.0秒
				if(time <= 60){

					// 何もしない

				// 1.0秒
				}else{

					// フェーズを進める
					phase = 0;
					// 時間を初期化
					time = 0;

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

		((KCtrlSKK)panel.getKCtrl()).addScore(100);

		super.bomb();

	} // end bomb

}
