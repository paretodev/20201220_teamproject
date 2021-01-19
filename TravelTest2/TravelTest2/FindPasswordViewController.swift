//
//  FindPasswordViewController.swift
//  TravelTest2
//
//  Created by 한석희 on 1/19/21.
//

import UIKit

class FindPasswordViewController: UIViewController {
    
    @IBOutlet weak var inputStackView: UIStackView!
    @IBOutlet weak var whiteBar: UIView!
    @IBOutlet weak var warningLabel: UILabel!
    @IBOutlet weak var userIDTextField: UITextField!
    @IBOutlet weak var okButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        initialViewSetting()

    }
    
    @IBAction func tryFindPassword(_ sender: Any) {
    }
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    //MARK:- Helper Function
    func initialViewSetting(){
        inputStackView.setCustomSpacing(5, after: whiteBar)
        warningLabel.textColor = UIColor(named: "nBlue")
        userIDTextField.attributedPlaceholder = NSAttributedString(string: "UserID", attributes: [NSAttributedString.Key.foregroundColor : UIColor.white])
        okButton.backgroundColor = .white
        okButton.layer.cornerRadius = 8
        okButton.setTitleColor(UIColor(named: "nBlue"), for: .normal)
    }
    
//
}
