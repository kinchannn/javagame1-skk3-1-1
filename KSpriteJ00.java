/**
 * 地面スプライト
 * <pre>
 * 地面スプライトオブジェクトとして共通化できる部分を記述します。
 * 型を判定するために、当クラスを作成しています。
 * <pre>
 */
public class KSpriteJ00 extends KSpriteT00 implements KConstant {

	/** 所属するスプライトグループ */
	private		KSpriteGroupJ00		spriteGroup		= null;

	/**
	 * コンストラクタ
	 * <pre>
	 * スプライトとスプライトグループの連携が必要ない場合は、当コンストラクタを使用ください。
	 * </pre>
	 * @param panel パネル
	 */
	public KSpriteJ00(KPanel panel){

		super(panel);

	}

	/**
	 * コンストラクタ
	 * <pre>
	 * スプライトとスプライトグループの連携が必要な場合は、当コンストラクタを使用ください。
	 * </pre>
	 * @param panel パネル
	 * @param spriteGroup スプライトグループ
	 */
	public KSpriteJ00(KPanel panel, KSpriteGroupJ00 spriteGroup){

		super(panel);

		// スプライトグループを保持
		this.spriteGroup = spriteGroup;

	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		// スーパークラスを呼び出す
		super.run();

		// スプライトグループが設定されている場合、
		if(spriteGroup != null){

			// 移動可能？
			if(spriteGroup.isMove()){

				// 移動
				intY = intY + 2;

				// 画面の外に出た場合、
				if(intY > HEIGHT){
					// スプライトを削除
					removeSprite();
				}

			}

		// スプライトグループが設定されていない場合
		}else{
			// 移動
			intY = intY + 2;

			// 画面の外に出た場合、
			if(intY > HEIGHT){
				// スプライトを削除
				removeSprite();
			}

		}

	} // end run

	/**
	 * スプライトグループ設定
	 * <pre>
	 * スプライトグループにスプライトの削除を通知する場合は、このメソッドで設定してください。
	 * <pre>
	 */
	public void setSpriteGroup(KSpriteGroupJ00 spriteGroup){
		this.spriteGroup = spriteGroup;
	}

	/**
	 * スプライト削除
	 * <pre>
	 * スプライトグループが存在する場合、スプライトが削除されたことを通知します。
	 * <pre>
	 */
	public void removeSprite(){

		// スプライトグループが存在する場合、
		if(spriteGroup != null){

			// G系スプライトの場合、
			if(this instanceof KSpriteG00){

				// スプライトグループにスプライトが削除されたことを通知する
				spriteGroup.removeSprite();

			}

		}

		// スーパークラスを呼び出す
		super.removeSprite();

	} // end removeSprite

}
