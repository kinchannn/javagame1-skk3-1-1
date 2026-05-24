/**
 * 敵１１ シンプルブラック
 */
public class KSpriteGroupT11 extends KSpriteGroup implements KConstant {

	/** 出現回数 */
	private		int			count		= 0;

	/** ビーム発射位置 */
	private		String		storyParam	= null;

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param storyParam ビーム発射位置
	 */
	public KSpriteGroupT11(KPanel panel, String storyParam){
		super(panel);
		this.storyParam = storyParam;
	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 一定時間経過の場合、
		if((time % 30) == 0){
			// スプライトを生成
			KSpriteT11 kSpriteT11 = new KSpriteT11(super.getKPanel(), storyParam);
			// スプライトを追加
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT11);

			// カウント＋１
			count++;

			// 20回出たら、
			if(count >= 20){
				// スプライトグループを消す
				super.getKPanel().removeSpriteGroup(this);
			}

		} // end if 一定時間経過の場合

	} // end run

}
