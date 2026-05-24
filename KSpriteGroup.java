/**
 * スプライトグループ
 * <pre>
 * スプライトを複数管理するクラス。
 * </pre>
 */
abstract public class KSpriteGroup extends KSpriteObject {

	/** パネル */
	protected KPanel panel = null;

	/** 時間 */
	public		int		time		= -1;

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 */
	public KSpriteGroup(KPanel panel){
		this.panel = panel;
	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	abstract public void run();

	/**
	 * 時間を進める
	 */
	public void forward(){
		time++;
	}

	/**
	 * パネル取得
	 */
	public KPanel getKPanel(){
		return panel;
	}

}
