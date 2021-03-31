package pokedex.egsys.features.details.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import pokedex.egsys.R
import pokedex.egsys.databinding.FragmentDetailsBinding
import pokedex.egsys.features.details.model.DetailsViewModel


class DetailsFragment : Fragment() {

        private lateinit var binding: FragmentDetailsBinding
    private val viewModel: DetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_details, container, false)
        binding = FragmentDetailsBinding.inflate(inflater)

//        viewModel.protocol = this
//
//        binding.loginFederalIdEditText.addTextChangedListener(
//            MaskCpfCnpj.insert(
//                binding.loginFederalIdEditText
//            )
//        )
//
//        binding.tvRegister.setOnClickListener {
//            val intent = Intent(
//                context,
//                RegisterActivity::class.java
//            )
//            startActivity(intent)
//        }
//
//        binding.tvForgotPassword.setOnClickListener {
//            val intent = Intent(
//                context,
//                ForgotPasswordActivity::class.java
//            )
//            startActivity(intent)
//        }
//
        return binding.root
    }
//
//    override fun onResume() {
//        super.onResume()
//
//        validPassword = false
//        validUser = false
//
//        binding.btnLogin.setOnClickListener {
//
//            pb_login.visibility = View.VISIBLE
//
//            setError()
//            if (validUser && validPassword) {
//                // observerEvents()
//
//                viewModel.loginUser(
//                    binding.loginFederalIdEditText.text.toString().unmask(),
//                    binding.loginPasswordEditText.text.toString(),
//                    EstabelecimentoApplication.APP_ESTABELECIMENTO
//                )
//                    .observe(this, Observer<BodyLogin> { loginResponse ->
//                        loginResponse?.let {
//                            pb_login.visibility = View.GONE
//                            saveUserSession(it)
//                            val intent = Intent(
//                                context,
//                                HomeActivity::class.java
//                            )
//                            startActivity(intent)
//                        }
//                    })
//
//            }
//        }
//    }
//
//    fun setError() {
//        // valida cnpj no click do botao
//        if (CpfCnpjUtil.isValid(binding.loginFederalIdEditText.text.toString())) {
//            binding.loginFederalIdInputlayout.error = ""
//            validUser = true
//        } else {
//            binding.loginFederalIdInputlayout.error = "CPF/CNPJ invalido"
//            validUser = false
//        }
//
//        if (binding.loginPasswordEditText.text.toString()
//                .isNotEmpty() && binding.loginPasswordEditText.text.toString().length == 5
//        ) {
//            binding.loginPasswordInputlayout.error = ""
//            validPassword = true
//        } else {
//            binding.loginPasswordInputlayout.error = "Senha invalida"
//            validPassword = false
//        }
//
//        //observa o texto digitado e valida se esta correto ou nao os dados
//        binding.loginFederalIdEditText.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(p0: Editable?) {
//            }
//
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                if (CpfCnpjUtil.isValid(binding.loginFederalIdEditText.text.toString())) {
//                    binding.loginFederalIdInputlayout.error = ""
//                    binding.btnLogin.isEnabled = true
//                } else {
//                    binding.loginFederalIdInputlayout.error = "CPF/CNPJ invalido"
//                    binding.btnLogin.isEnabled = false
//                }
//            }
//        })
//
//        binding.loginPasswordEditText.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(p0: Editable?) {
//            }
//
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                if (binding.loginPasswordEditText.text.toString()
//                        .isNotEmpty() && binding.loginPasswordEditText.text.toString().length == 5
//                ) {
//                    binding.loginPasswordInputlayout.error = ""
//                    binding.btnLogin.isEnabled = true
//                } else {
//                    binding.loginPasswordInputlayout.error = "Senha invalida"
//                    binding.btnLogin.isEnabled = false
//                }
//            }
//        })
//    }
//
//    override fun onBackPressed() {
//    }
//
//    override fun responseError(message: String) {
//        pb_login.visibility = View.GONE
//        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
//    }

}