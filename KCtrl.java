import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;

/**
 * コントロールクラス
 * <pre>
 * 全体的な制御を行うスーパークラス。
 * 実際には、継承したクラスで制御を行ってください。
 * </pre>
 */
abstract public class KCtrl {

	private		Container			con					= null;

	/**
	 * コンストラクタ
	 * @param con コンテナ
	 */
	public KCtrl(Container con){

		this.con = con;

	} // end KCtrl

	/**
	 * 開始
	 * <pre>
	 * 当オブジェクトの処理を開始します。
	 * 継承先で定義をしてください。
	 * </pre>
	 */
	abstract public void start();

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * </pre>
	 * @return  true：正常 ／ false：一時停止
	 */
	abstract public boolean run();

	/**
	 * 親コンテナ取得
	 * <pre>
	 * 当クラス自体はCompnetクラスを継承はしていないが、親コンテナより生成される作りとしている。
	 * そのため、自分を生成したクラスを内部的に保持しておき、その後の処理に適宜利用する。
	 * </pre>
	 * @return Container コンテナ
	 */
	public Container getParent(){

		return con;

	} // getParent

}
