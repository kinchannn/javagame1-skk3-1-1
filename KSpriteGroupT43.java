import java.util.*;

/**
 * 敵４２
 */
public class KSpriteGroupT43 extends KSpriteGroup implements KConstant {

	/** 残機 */
	private static final int				REMAINING		= 5;

	/** 時間 */
	private			int						time			= -1;

	/** スプライト一覧 */
	private			ArrayList<KSpriteT43>	kSpriteT43Lst	= new ArrayList<KSpriteT43>();

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 */
	public KSpriteGroupT43(KPanel panel){

		super(panel);

	} // end KSpriteGroupT43

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 時間＋１
		time++;

		// 時間がきたら
		if(time == 0 || time == 60 || time == 120 || time == 180 || time == 240 || time == 300){

			// 5機出現
			for(int i = 0; i < REMAINING; i++){

				// スプライトを生成
				KSpriteT43 kSpriteT43 = new KSpriteT43(super.getKPanel(), i);
				// スプライトを追加
				super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT43);

				// スプライト一覧に保持
				kSpriteT43Lst.add(kSpriteT43);

			}

		}

	} // end run

	/**
	 * 全ての残っている敵機を破壊
	 * <pre>
	 * 全ての残っている敵機を破壊します。
	 * <pre>
	 */
	public void allBomb(){

		// スプライト一覧の件数を取得
		int countKSpriteT43Lst = kSpriteT43Lst.size();

		// 5機ループ
		for(int i = 0; i < countKSpriteT43Lst; i++){

			// スプライトを取得
			KSpriteT43 kSpriteT43 = kSpriteT43Lst.get(i);

			// まだ破壊していない場合、
			if(!kSpriteT43.isBomb()){

				// 破壊する
				kSpriteT43.bomb();

			}

		} // 8機ループ

		// スプライトグループを消す
		super.getKPanel().removeSpriteGroup(this);

	} // end allBomb

	/**
	 * スプライト削除
	 * <pre>
	 * スプライトグループで管理しているスプライトを削除します。
	 * <pre>
	 */
//	public void removeSprite(){

//	} // end removeSprite

}
