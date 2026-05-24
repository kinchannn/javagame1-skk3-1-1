import java.util.*;

/**
 * 敵３４
 */
public class KSpriteGroupT34 extends KSpriteGroup implements KConstant {

	/** パラメータ */
	private			String		storyParam		= null;

	/** 残機 */
	private			int			remaining		= 0;

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 */
	public KSpriteGroupT34(KPanel panel, String storyParam){

		super(panel);

		this.storyParam = storyParam;

		// ストーリーを停止する
		((KCtrlSKK)panel.getKCtrl()).getKStory().stop();

		StringTokenizer st = new StringTokenizer(this.storyParam, "_");

		// トークンがある場合、
		while(st.hasMoreTokens()){

			// 次のトークンを取得
			String strToken = st.nextToken();

			// スプライトを生成
			KSpriteT34 kSpriteT34 = new KSpriteT34(super.getKPanel(), strToken, this);
			// スプライトを追加
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT34);

			// 残機＋１
			remaining++;

		} // end while トークンがある場合

		// スプライトグループを消す
		super.getKPanel().removeSpriteGroup(this);

	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

	} // end run

	/**
	 * スプライト削除
	 * <pre>
	 * スプライトグループで管理しているスプライトを削除します。
	 * <pre>
	 */
	public void removeSprite(){

		// 残機−１
		remaining--;

		// 残機が無くなった場合、
		if(remaining == 0){

			// ストーリーを再開する
			((KCtrlSKK)panel.getKCtrl()).getKStory().start();

			// スプライトグループを消す
			super.getKPanel().removeSpriteGroup(this);

		}

	} // end removeSprite

}
