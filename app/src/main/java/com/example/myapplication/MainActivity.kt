package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var oldText = "0"
    private var operator = ""
    private var newText = "0"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setNumbersOnView()
        clear.setOnClickListener { clear() }
        backspace.setOnClickListener { back() }
        calculate()
    }

    private fun calculate() {
        equal.setOnClickListener {
            calculateOperator()
            old_text.text=oldText
            new_text.text="0"
        }
        procent.setOnClickListener {
            calculateOperator()
            operator="%"
            old_text.text=oldText+operator
            newText="0"
            new_text.text=newText
        }
        add.setOnClickListener {
            calculateOperator()
            operator="+"
            old_text.text = oldText+operator
            newText="0"
            new_text.text = newText
        }
        minus.setOnClickListener {
            calculateOperator()
            operator="-"
            old_text.text = oldText+operator
            newText="0"
            new_text.text = newText
        }
        multiply.setOnClickListener {
            calculateOperator()
            operator="*"
            old_text.text = oldText+operator
            newText="0"
            new_text.text = newText
        }
        divid.setOnClickListener {
            calculateOperator()
            operator="/"
            old_text.text = oldText+operator
            newText="0"
            new_text.text = newText
        }
    }

    private fun calculateOperator() {
        var result = 0.0
        if (operator.isEmpty()) {
            oldText = newText
        } else if (operator.equals("+")) {
            result = oldText.toDouble() + newText.toDouble()
            oldText = result.toString()
        } else if (operator.equals("-")) {
            result = oldText.toDouble() - newText.toDouble()
            oldText = result.toString()
        } else if (operator.equals("*")) {
            if (operator.equals("0")) {
                oldText = newText
            } else if (!newText.equals("0")) {
                result = oldText.toDouble() * newText.toDouble()
                oldText = result.toString()
            }
        } else if (operator.equals("/")) {
            if (oldText.equals("0")) {
                oldText = newText
            } else if (!newText.equals("0")) {
                result = oldText.toDouble() / newText.toDouble()
                oldText = result.toString()
            }
        } else if (operator.equals("%")){
            if (!oldText.equals("0")){
                result = oldText.toDouble()*newText.toDouble()/100
                oldText = result.toString()
            }
        }
    }

        private fun back() {
            if (newText.length > 1) {
                newText = newText.substring(0, newText.length - 1)
                new_text.text = newText
            } else if (newText.length == 1) {
                newText = "0"
                new_text.text = "0"
            }
        }
        private fun clear() {
            operator = ""
            oldText = "0"
            newText = "0"
            old_text.text = "0"
            new_text.text = "0"
        }

        private fun checked(str: String): String {
            if (str.equals("0")) {
                return ""
            } else {
                return str
            }
        }

        private fun setNumbersOnView() {
            one.setOnClickListener {if (new_text.length() < 10) newText = checked(newText) + "1";new_text.text = newText}
            two.setOnClickListener {if (new_text.length() < 10) newText = checked(newText) + "2";new_text.text = newText }
            three.setOnClickListener {if (new_text.length() < 10) newText = checked(newText) + "3";new_text.text = newText }
            four.setOnClickListener {if (new_text.length() < 10) newText = checked(newText) + "4";new_text.text = newText }
            five.setOnClickListener { if (new_text.length() < 10) newText = checked(newText) + "5";new_text.text = newText }
            six.setOnClickListener {if (new_text.length() < 10) newText = checked(newText) + "6";new_text.text = newText }
            seven.setOnClickListener {if (new_text.length() < 10) newText = checked(newText) + "7";new_text.text = newText }
            eight.setOnClickListener {if (new_text.length() < 10) newText = checked(newText) + "8";new_text.text = newText }
            nine.setOnClickListener {if (new_text.length() < 10) newText = checked(newText) + "9";new_text.text = newText }
            zero.setOnClickListener {if (new_text.length() < 10) newText = checked(newText) + "0";new_text.text = newText}
            point.setOnClickListener { if (new_text.length() < 10) setPoint() }

        }

        private fun setPoint() {
            if (!newText.contains('.')) {
                if (newText.equals("0")) {
                    newText = checked(newText) + "0.";new_text.text = newText
                } else {
                    newText = checked(newText) + ".";new_text.text = newText
                }
            }
        }


    }
