package com.example.shoestore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shoestore.databinding.FragmentRegisterConsultBinding

class RegisterConsultFragment : Fragment() {
    private lateinit var binding: FragmentRegisterConsultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterConsultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val phone = binding.etPhone.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(requireContext(), "Vui lòng nhập họ và tên", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (phone.isEmpty()) {
                Toast.makeText(requireContext(), "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Bạn có thể thêm điều kiện kiểm tra số điện thoại hợp lệ ở đây nếu muốn

            Toast.makeText(requireContext(), "Bạn đã đăng ký tư vấn thành công!", Toast.LENGTH_SHORT).show()
        }
    }

}
