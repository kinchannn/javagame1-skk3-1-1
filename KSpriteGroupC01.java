import java.awt.*;

/**
 * クリア
 */
public class KSpriteGroupC01 extends KSpriteGroup implements KConstant {

	private		KText		kTextClear	= null;

	/**
	 * コンストラクタ
	 */
	public KSpriteGroupC01(KPanel panel){

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
			kTextClear = new KText(super.getKPanel(), 230, 250);
			kTextClear.setFont(new Font("HG丸ｺﾞｼｯｸM-PRO", Font.PLAIN, 16));
			super.getKPanel().addText("CLEAR", kTextClear);
			kTextClear.setText("STAGE ".concat(Integer.toString(kCTrlSKK.getStage())).concat(" CLEAR"));

		// ステージクリア表示終わりになったら、
		}else if(time == 720){

			// パネルを取得
			KPanel panel = super.getKPanel();

			// メッセージを非表示
			super.getKPanel().removeText("CLEAR");

			// コントロールクラス取得
			KCtrlSKK kCTrlSKK = (KCtrlSKK)(super.getKPanel().getKCtrl());

			// 地面のスプライト層を初期化
			panel.initKSpriteLstInLayout(LAYOUT_JIMEN_0);

			// 地面のスプライト層を初期化
			panel.initKSpriteLstInLayout(LAYOUT_JIMEN_1);

			// 敵のスプライト層を初期化
			panel.initKSpriteLstInLayout(LAYOUT_TEKI);

			// ステージ＋１
			kCTrlSKK.addStage();

			// フェーズ再開
			kCTrlSKK.restart();

			// ストーリをスタート
			kCTrlSKK.getKStory().start();

			super.getKPanel().removeSpriteGroup(this);

		}

	} // end run

}
