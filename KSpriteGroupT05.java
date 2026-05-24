/**
 * 敵５
 */
public class KSpriteGroupT05 extends KSpriteGroup implements KConstant {

	/** ビーム発射位置 */
	private		String		storyParam	= null;

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param storyParam ビーム発射位置
	 */
	public KSpriteGroupT05(KPanel panel, String storyParam){
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
		if((time % 20) == 0){
			// スプライトを生成
			KSpriteT05 kSpriteT05 = new KSpriteT05(super.getKPanel(), storyParam);
			// スプライトを追加
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT05);
		}

		// 15回出たら、
		if(time == 280){
			// スプライトグループを消す
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
