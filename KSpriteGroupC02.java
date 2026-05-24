import java.awt.*;

/**
 * クリア
 */
public class KSpriteGroupC02 extends KSpriteGroup implements KConstant {

	private		KText		kTextClearScore		= null;
	private		KText		kTextClearScore0	= null;
	private		KText		kTextClearBonus		= null;
	private		KText		kTextClearScore1	= null;

	/**
	 * コンストラクタ
	 */
	public KSpriteGroupC02(KPanel panel){

		super(panel);

		// ストーリーを停止する
		((KCtrlSKK)panel.getKCtrl()).getKStory().stop();


	}

	/**
	 * 実行
	 */
	public void run(){

		// 一定時間経過の場合、
		if(time <= 64 && (time % 16) == 0){
			for(int i = 0; i < 600; i = i + 32){
				KSpriteJ02 kSpriteJ02 = new KSpriteJ02(super.getKPanel(), i);
				super.getKPanel().addSprite(LAYOUT_JIMEN_0, kSpriteJ02);
			}
		}

		// 地面が非表示になったら、
		if(time == 320){

			// ステージクリア
			KCtrlSKK kCTrlSKK = (KCtrlSKK)(super.getKPanel().getKCtrl());
			kCTrlSKK.stageClear();

			// メッセージ表示
			kTextClearScore = new KText(super.getKPanel(), 250, 250);
			kTextClearScore.setFont(new Font("HG丸ｺﾞｼｯｸM-PRO", Font.PLAIN, 16));
			super.getKPanel().addText("CLEAR", kTextClearScore);
			kTextClearScore.setText("ALL CLEAR");

			// メッセージ表示
			kTextClearScore0 = new KText(super.getKPanel(), 150, 350);
			kTextClearScore0.setFont(new Font("HG丸ｺﾞｼｯｸM-PRO", Font.PLAIN, 16));
			super.getKPanel().addText("CLEAR_SCORE_0", kTextClearScore0);
			kTextClearScore0.setText("SCORE       : " + kCTrlSKK.getScore());

			// 防御取得
			int shield = kCTrlSKK.getShield();

			// 防御分加算
			kCTrlSKK.addScore(shield * 10000);

			// メッセージ表示
			kTextClearBonus = new KText(super.getKPanel(), 150, 390);
			kTextClearBonus.setFont(new Font("HG丸ｺﾞｼｯｸM-PRO", Font.PLAIN, 16));
			super.getKPanel().addText("CLEAR_BONUS", kTextClearBonus);
			kTextClearBonus.setText("BONUS SHIELD  " + shield + " X 10,000 = " + shield * 10000);

			// メッセージ表示
			kTextClearScore1 = new KText(super.getKPanel(), 150, 430);
			kTextClearScore1.setFont(new Font("HG丸ｺﾞｼｯｸM-PRO", Font.PLAIN, 16));
			super.getKPanel().addText("CLEAR_SCORE_1", kTextClearScore1);
			kTextClearScore1.setText("CLEAR SCORE : " + kCTrlSKK.getScore());

		}

		// ステージクリア表示終わりになったら、
		if(time == 1000){

			// パネルを取得
			KPanel panel = super.getKPanel();

			// メッセージを非表示
			panel.removeText("CLEAR");
			panel.removeText("CLEAR_SCORE_0");
			panel.removeText("CLEAR_BONUS");
			panel.removeText("CLEAR_SCORE_1");

			// 地面のスプライト層を初期化
			panel.initKSpriteLstInLayout(LAYOUT_JIMEN_0);

			// 地面のスプライト層を初期化
			panel.initKSpriteLstInLayout(LAYOUT_JIMEN_1);

			// 敵のスプライト層を初期化
			panel.initKSpriteLstInLayout(LAYOUT_TEKI);

			// オールクリア
			KCtrlSKK kCTrlSKK = (KCtrlSKK)(super.getKPanel().getKCtrl());
			kCTrlSKK.allClear();

			// ストーリをスタート
			kCTrlSKK.getKStory().start();

			super.getKPanel().removeSpriteGroup(this);

		}

	} // end run

}
