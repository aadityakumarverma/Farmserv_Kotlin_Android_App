package com.example.farmserv
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.example.farmserv.databinding.RegistrationBinding
import kotlinx.android.synthetic.main.home_flow.*
import kotlinx.android.synthetic.main.registration.*
import kotlinx.android.synthetic.main.registration.validate_MobileNumber
import kotlinx.android.synthetic.main.user_login.*


class Registration : AppCompatActivity() {

    lateinit var binding : RegistrationBinding
    lateinit var window :PopupWindow
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)
        binding = RegistrationBinding.inflate(layoutInflater)



        /*val mobileInput= intent.getStringExtra("numberInput")
        fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

        if (mobileInput != null) {
            et_MobileNumber.text = mobileInput.toEditable()
        }*/







        val state=arrayOf("Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh (UT)",
                        "Chhattisgarh", "Dadra and Nagar Haveli (UT)", "Daman and Diu (UT)", "Delhi (NCT)",
                        "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand",
                        "Karnataka", "Kerala", "Lakshadweep (UT)", "Madhya Pradesh", "Maharashtra", "Manipur",
                        "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Puducherry (UT)", "Punjab", "Rajasthan",
                        "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal")


        val allDistrict = arrayOf(
            arrayOf("Anantapur" ,  "Chittoor" ,  "East Godavari" ,  "Guntur" ,  "Krishna" ,  "Kurnool" ,
            "Nellore" ,  "Prakasam" ,  "Srikakulam" ,  "Visakhapatnam" ,  "Vizianagaram" ,  "West Godavari" ,  "YSR Kadapa")
            ,  arrayOf("Tawang" ,  "West Kameng" ,  "East Kameng" ,  "Papum Pare" ,  "Kurung Kumey" ,  "Kra Daadi" ,
                "Lower Subansiri" ,  "Upper Subansiri" ,  "West Siang" ,  "East Siang" ,  "Siang" ,  "Upper Siang" ,
                "Lower Siang" ,  "Lower Dibang Valley" ,  "Dibang Valley" ,  "Anjaw" ,  "Lohit" ,  "Namsai" ,  "Changlang" ,
                "Tirap" ,  "Longding") ,
            arrayOf("Baksa" ,  "Barpeta" ,  "Biswanath" ,  "Bongaigaon" ,  "Cachar" ,
                "Charaideo" ,  "Chirang" ,  "Darrang" ,  "Dhemaji" ,  "Dhubri" ,  "Dibrugarh" ,  "Goalpara" ,  "Golaghat" ,
                "Hailakandi" ,  "Hojai" ,  "Jorhat" ,  "Kamrup Metropolitan" ,  "Kamrup" ,  "Karbi Anglong" ,  "Karimganj" ,
                "Kokrajhar" ,  "Lakhimpur" ,  "Majuli" ,  "Morigaon" ,  "Nagaon" ,  "Nalbari" ,  "Dima Hasao" ,  "Sivasagar" ,
                "Sonitpur" ,  "South Salmara-Mankachar" ,  "Tinsukia" ,  "Udalguri" ,  "West Karbi Anglong") ,
            arrayOf("Araria" ,  "Arwal" ,  "Aurangabad" ,  "Banka" ,  "Begusarai" ,  "Bhagalpur" ,  "Bhojpur" ,  "Buxar" ,
                "Darbhanga" ,  "East Champaran (Motihari)" ,  "Gaya" ,  "Gopalganj" ,  "Jamui" ,  "Jehanabad" ,
                "Kaimur (Bhabua)" ,  "Katihar" ,  "Khagaria" ,  "Kishanganj" ,  "Lakhisarai" ,  "Madhepura" ,  "Madhubani" ,
                "Munger (Monghyr)" ,  "Muzaffarpur" ,  "Nalanda" ,  "Nawada" ,  "Patna" ,  "Purnia (Purnea)" ,  "Rohtas" ,
                "Saharsa" ,  "Samastipur" ,  "Saran" ,  "Sheikhpura" ,  "Sheohar" ,  "Sitamarhi" ,  "Siwan" ,  "Supaul" ,
                "Vaishali" ,  "West Champaran") ,
            arrayOf("Chandigarh") ,
            arrayOf("Balod" ,  "Baloda Bazar" ,  "Balrampur" ,  "Bastar" ,  "Bemetara" ,  "Bijapur" ,
                "Bilaspur" ,  "Dantewada (South Bastar)" ,  "Dhamtari" ,  "Durg" ,  "Gariyaband" ,
                "Janjgir-Champa" ,  "Jashpur" ,  "Kabirdham (Kawardha)" ,  "Kanker (North Bastar)" ,
                "Kondagaon" ,  "Korba" ,  "Korea (Koriya)" ,  "Mahasamund" ,  "Mungeli" ,  "Narayanpur" ,
                "Raigarh" ,  "Raipur" ,  "Rajnandgaon" ,  "Sukma" ,  "Surajpur  " ,  "Surguja") ,
            arrayOf("Dadra & Nagar Haveli") ,
            arrayOf("Daman" ,  "Diu") ,
            arrayOf("Central Delhi" ,  "East Delhi" , "New Delhi" , "North Delhi" , "North East  Delhi" ,
                "North West  Delhi" ,"Shahdara" ,  "South Delhi" ,  "South East Delhi" , "South West  Delhi" ,  "West Delhi") ,
            arrayOf("North Goa" ,  "South Goa") ,
            arrayOf("Ahmedabad" ,  "Amreli" ,  "Anand" ,  "Aravalli" ,  "Banaskantha (Palanpur)" ,  "Bharuch" ,
                "Bhavnagar" ,  "Botad" ,  "Chhota Udepur" ,  "Dahod" ,  "Dangs (Ahwa)" ,  "Devbhoomi Dwarka" ,
                "Gandhinagar" ,  "Gir Somnath" ,  "Jamnagar" ,  "Junagadh" ,  "Kachchh" ,  "Kheda (Nadiad)" ,
                "Mahisagar" ,  "Mehsana" ,  "Morbi" ,  "Narmada (Rajpipla)" ,  "Navsari" ,  "Panchmahal (Godhra)" ,
                "Patan" ,  "Porbandar" ,  "Rajkot" ,  "Sabarkantha (Himmatnagar)" ,  "Surat" ,  "Surendranagar" ,
                "Tapi (Vyara)" ,  "Vadodara" ,  "Valsad") ,
            arrayOf("Ambala" ,  "Bhiwani" ,  "Charkhi Dadri" ,  "Faridabad" ,  "Fatehabad" ,  "Gurgaon" ,  "Hisar" ,
                "Jhajjar" ,  "Jind" ,  "Kaithal" ,  "Karnal" ,  "Kurukshetra" ,  "Mahendragarh" ,  "Mewat" ,  "Palwal" ,
                "Panchkula" ,  "Panipat" ,  "Rewari" ,  "Rohtak" ,  "Sirsa" ,  "Sonipat" ,  "Yamunanagar") ,
            arrayOf("Bilaspur" ,  "Chamba" ,  "Hamirpur" ,  "Kangra" ,  "Kinnaur" ,  "Kullu" ,  "Lahaul &amp; Spiti" ,
                "Mandi" ,  "Shimla" ,  "Sirmaur (Sirmour)" ,  "Solan" ,  "Una") ,
            arrayOf("Anantnag" ,  "Bandipore" ,  "Baramulla" ,  "Budgam" ,  "Doda" ,  "Ganderbal" ,  "Jammu" ,
                "Kargil" ,  "Kathua" ,  "Kishtwar" ,  "Kulgam" ,  "Kupwara" ,  "Leh" ,  "Poonch" ,  "Pulwama" ,
                "Rajouri" ,  "Ramban" ,  "Reasi" ,  "Samba" ,  "Shopian" ,  "Srinagar" ,  "Udhampur") ,
            arrayOf("Bokaro" ,  "Chatra" ,  "Deoghar" ,  "Dhanbad" ,  "Dumka" ,  "East Singhbhum" ,  "Garhwa" ,
                "Giridih" ,  "Godda" ,  "Gumla" ,  "Hazaribag" ,  "Jamtara" ,  "Khunti" ,  "Koderma" ,  "Latehar" ,
                "Lohardaga" ,  "Pakur" ,  "Palamu" ,  "Ramgarh" ,  "Ranchi" ,  "Sahibganj" ,  "Seraikela-Kharsawan" ,
                "Simdega" ,  "West Singhbhum") ,
            arrayOf("Bagalkot" ,  "Ballari (Bellary)" ,  "Belagavi (Belgaum)" , "Bengaluru (Bangalore) Rural" ,
                "Bengaluru (Bangalore) Urban" ,  "Bidar" ,  "Chamarajanagar" ,  "Chikballapur" ,
                "Chikkamagaluru (Chikmagalur)" ,  "Chitradurga" ,  "Dakshina Kannada" ,  "Davangere" ,  "Dharwad" ,
                "Gadag" ,  "Hassan" ,  "Haveri" ,  "Kalaburagi (Gulbarga)" ,  "Kodagu" ,  "Kolar" ,  "Koppal" ,  "Mandya" ,
                "Mysuru (Mysore)" ,  "Raichur" ,  "Ramanagara" ,  "Shivamogga (Shimoga)" ,  "Tumakuru (Tumkur)" ,  "Udupi" ,
                "Uttara Kannada (Karwar)" ,  "Vijayapura (Bijapur)" ,  "Yadgir") ,
            arrayOf("Alappuzha" ,  "Ernakulam" ,  "Idukki" ,  "Kannur" ,  "Kasaragod" ,  "Kollam" ,  "Kottayam" ,
                "Kozhikode" ,  "Malappuram" ,  "Palakkad" ,  "Pathanamthitta" ,  "Thiruvananthapuram" ,  "Thrissur" ,
                "Wayanad") ,
            arrayOf("Agatti" ,  "Amini" ,  "Androth" ,  "Bithra" ,  "Chethlath" ,  "Kavaratti" ,
                "Kadmath" ,  "Kalpeni" ,  "Kilthan" ,  "Minicoy") ,
            arrayOf("Agar Malwa" ,  "Alirajpur" ,  "Anuppur" ,  "Ashoknagar" ,  "Balaghat" ,  "Barwani" ,  "Betul" ,  "Bhind" ,
                "Bhopal" ,  "Burhanpur" ,  "Chhatarpur" ,  "Chhindwara" ,  "Damoh" ,  "Datia" ,  "Dewas" ,  "Dhar" ,
                "Dindori" ,  "Guna" ,  "Gwalior" ,  "Harda" ,  "Hoshangabad" ,  "Indore" ,  "Jabalpur" ,  "Jhabua" ,
                "Katni" ,  "Khandwa" ,  "Khargone" ,  "Mandla" ,  "Mandsaur" ,  "Morena" ,  "Narsinghpur" ,  "Neemuch" ,
                "Panna" ,  "Raisen" ,  "Rajgarh" ,  "Ratlam" ,  "Rewa" ,  "Sagar" ,  "Satna" ,  "Sehore" ,  "Seoni" ,
                "Shahdol" ,  "Shajapur" ,  "Sheopur" ,  "Shivpuri" ,  "Sidhi" ,  "Singrauli" ,  "Tikamgarh" ,  "Ujjain" ,
                "Umaria" ,  "Vidisha") ,
            arrayOf("Ahmednagar" ,  "Akola" ,  "Amravati" ,  "Aurangabad" ,  "Beed" ,
                "Bhandara" ,  "Buldhana" ,  "Chandrapur" ,  "Dhule" ,  "Gadchiroli" ,  "Gondia" ,  "Hingoli" ,  "Jalgaon" ,
                "Jalna" ,  "Kolhapur" ,  "Latur" ,  "Mumbai City" ,  "Mumbai Suburban" ,  "Nagpur" ,  "Nanded" ,
                "Nandurbar" ,  "Nashik" ,  "Osmanabad" ,  "Palghar" ,  "Parbhani" ,  "Pune" ,  "Raigad" ,  "Ratnagiri" ,
                "Sangli" ,  "Satara" ,  "Sindhudurg" ,  "Solapur" ,  "Thane" ,  "Wardha" ,  "Washim" ,  "Yavatmal") ,
            arrayOf("Bishnupur" ,  "Chandel" ,  "Churachandpur" ,  "Imphal East" ,  "Imphal West" ,  "Jiribam" ,
                "Kakching" ,  "Kamjong" ,  "Kangpokpi" ,  "Noney" ,  "Pherzawl" ,  "Senapati" ,  "Tamenglong" ,
                "Tengnoupal" ,  "Thoubal" ,  "Ukhrul") ,
            arrayOf("East Garo Hills" ,  "East Jaintia Hills" ,  "East Khasi Hills" ,  "North Garo Hills" ,  "Ri Bhoi" ,
                "South Garo Hills" ,  "South West Garo Hills " ,  "South West Khasi Hills" ,  "West Garo Hills" ,
                "West Jaintia Hills" ,  "West Khasi Hills") ,
            arrayOf("Aizawl" ,  "Champhai" ,  "Kolasib" ,  "Lawngtlai" ,  "Lunglei" ,  "Mamit" ,  "Saiha" ,  "Serchhip") ,
            arrayOf("Dimapur" ,  "Kiphire" ,  "Kohima" ,  "Longleng" ,  "Mokokchung" ,  "Mon" ,  "Peren" ,  "Phek" ,  "Tuensang" ,
                "Wokha" ,  "Zunheboto") ,
            arrayOf("Angul" ,  "Balangir" ,  "Balasore" ,  "Bargarh" ,  "Bhadrak" ,  "Boudh" ,
                "Cuttack" ,  "Deogarh" ,  "Dhenkanal" ,  "Gajapati" ,  "Ganjam" ,  "Jagatsinghapur" ,  "Jajpur" ,  "Jharsuguda" ,
                "Kalahandi" ,  "Kandhamal" ,  "Kendrapara" ,  "Kendujhar (Keonjhar)" ,  "Khordha" ,  "Koraput" ,  "Malkangiri" ,
                "Mayurbhanj" ,  "Nabarangpur" ,  "Nayagarh" ,  "Nuapada" ,  "Puri" ,  "Rayagada" ,  "Sambalpur" ,  "Sonepur" ,
                "Sundargarh") ,
            arrayOf("Karaikal" ,  "Mahe" ,  "Pondicherry" ,  "Yanam") ,
            arrayOf("Amritsar" ,  "Barnala" ,  "Bathinda" ,  "Faridkot" ,  "Fatehgarh Sahib" ,  "Fazilka" ,  "Ferozepur" ,
                "Gurdaspur" ,  "Hoshiarpur" ,  "Jalandhar" ,  "Kapurthala" ,  "Ludhiana" ,  "Mansa" ,  "Moga" ,  "Muktsar" ,
                "Nawanshahr (Shahid Bhagat Singh Nagar)" ,  "Pathankot" ,  "Patiala" ,  "Rupnagar" ,  "Sahibzada Ajit Singh Nagar ",
                "Sangrur" ,  "Tarn Taran") ,
            arrayOf("Ajmer" ,  "Alwar" ,  "Banswara" ,  "Baran" ,  "Barmer" ,  "Bharatpur" ,  "Bhilwara" ,  "Bikaner" ,  "Bundi" ,
                "Chittorgarh" ,  "Churu" ,  "Dausa" ,  "Dholpur" ,  "Dungarpur" ,  "Hanumangarh" ,  "Jaipur" ,  "Jaisalmer" ,
                "Jalore" ,  "Jhalawar" ,  "Jhunjhunu" ,  "Jodhpur" ,  "Karauli" ,  "Kota" ,  "Nagaur" ,  "Pali" ,  "Pratapgarh" ,
                "Rajsamand" ,  "Sawai Madhopur" ,  "Sikar" ,  "Sirohi" ,  "Sri Ganganagar" ,  "Tonk" ,  "Udaipur") ,
            arrayOf("East Sikkim" ,  "North Sikkim" ,  "South Sikkim" ,  "West Sikkim") ,
            arrayOf("Ariyalur" ,  "Chennai" ,  "Coimbatore" ,  "Cuddalore" ,  "Dharmapuri" ,  "Dindigul" ,  "Erode" ,  "Kanchipuram" ,
                "Kanyakumari" ,  "Karur" ,  "Krishnagiri" ,  "Madurai" ,  "Nagapattinam" ,  "Namakkal" ,  "Nilgiris" ,  "Perambalur" ,
                "Pudukkottai" ,  "Ramanathapuram" ,  "Salem" ,  "Sivaganga" ,  "Thanjavur" ,  "Theni" ,  "Thoothukudi (Tuticorin)" ,
                "Tiruchirappalli" ,  "Tirunelveli" ,  "Tiruppur" ,  "Tiruvallur" ,  "Tiruvannamalai" ,  "Tiruvarur" ,  "Vellore" ,
                "Viluppuram" ,  "Virudhunagar") ,
            arrayOf("Adilabad" ,  "Bhadradri Kothagudem" ,  "Hyderabad" ,  "Jagtial" ,
                "Jangaon" ,  "Jayashankar Bhoopalpally" ,  "Jogulamba Gadwal" ,  "Kamareddy" ,  "Karimnagar" ,  "Khammam" ,
                "Komaram Bheem Asifabad" ,  "Mahabubabad" ,  "Mahabubnagar" ,  "Mancherial" ,  "Medak" ,  "Medchal" ,
                "Nagarkurnool" ,  "Nalgonda" ,  "Nirmal" ,  "Nizamabad" ,  "Peddapalli" ,  "Rajanna Sircilla" ,  "Rangareddy" ,
                "Sangareddy" ,  "Siddipet" ,  "Suryapet" ,  "Vikarabad" ,  "Wanaparthy" ,  "Warangal (Rural)" ,  "Warangal (Urban)" ,
                "Yadadri Bhuvanagiri") ,
            arrayOf("Dhalai" ,  "Gomati" ,  "Khowai" ,  "North Tripura" ,  "Sepahijala" ,  "South Tripura" ,  "Unakoti" ,
                "West Tripura") ,
            arrayOf("Almora" ,  "Bageshwar" ,  "Chamoli" ,  "Champawat" ,  "Dehradun" ,  "Haridwar" ,  "Nainital" ,
                "Pauri Garhwal" ,  "Pithoragarh" ,  "Rudraprayag" ,  "Tehri Garhwal" ,  "Udham Singh Nagar" ,  "Uttarkashi") ,
            arrayOf("Agra" ,  "Aligarh" ,  "Allahabad" ,  "Ambedkar Nagar" ,  "Amethi (Chatrapati Sahuji Mahraj Nagar)" ,
                "Amroha (J.P. Nagar)" ,  "Auraiya" ,  "Azamgarh" ,  "Baghpat" ,  "Bahraich" ,  "Ballia" ,  "Balrampur" ,  "Banda" ,
                "Barabanki" ,  "Bareilly" ,  "Basti" ,  "Bhadohi" ,  "Bijnor" ,  "Budaun" ,  "Bulandshahr" ,  "Chandauli" ,
                "Chitrakoot" ,  "Deoria" ,  "Etah" ,  "Etawah" ,  "Faizabad" ,  "Farrukhabad" ,  "Fatehpur" ,  "Firozabad" ,
                "Gautam Buddha Nagar" ,  "Ghaziabad" ,  "Ghazipur" ,  "Gonda" ,  "Gorakhpur" ,  "Hamirpur" ,
                "Hapur (Panchsheel Nagar)" ,  "Hardoi" ,  "Hathras" ,  "Jalaun" ,  "Jaunpur" ,  "Jhansi" ,  "Kannauj" ,
                "Kanpur Dehat" ,  "Kanpur Nagar" ,  "Kanshiram Nagar (Kasganj)" ,  "Kaushambi" ,  "Kushinagar (Padrauna)" ,
                "Lakhimpur - Kheri" ,  "Lalitpur" ,  "Lucknow" ,  "Maharajganj" ,  "Mahoba" ,  "Mainpuri" ,  "Mathura" ,  "Mau" ,
                "Meerut" ,  "Mirzapur" ,  "Moradabad" ,  "Muzaffarnagar" ,  "Pilibhit" ,  "Pratapgarh" ,  "RaeBareli" ,  "Rampur" ,
                "Saharanpur" ,  "Sambhal (Bhim Nagar)" ,  "Sant Kabir Nagar" ,  "Shahjahanpur" ,  "Shamali (Prabuddh Nagar)" ,
                "Shravasti" ,  "Siddharth Nagar" ,  "Sitapur" ,  "Sonbhadra" ,  "Sultanpur" ,  "Unnao" ,  "Varanasi") ,
            arrayOf("Alipurduar" ,  "Bankura" ,  "Birbhum" ,  "Burdwan (Bardhaman)" ,  "Cooch Behar" ,
                "Dakshin Dinajpur (South Dinajpur)" ,  "Darjeeling" ,  "Hooghly" ,  "Howrah" ,  "Jalpaiguri" ,  "Kalimpong" ,
                "Kolkata" ,  "Malda" ,  "Murshidabad" ,  "Nadia" ,  "North 24 Parganas" ,  "Paschim Medinipur (West Medinipur)" ,
                "Purba Medinipur (East Medinipur)" ,  "Purulia" ,  "South 24 Parganas" ,  "Uttar Dinajpur (North Dinajpur)"))

        var stateIndex=0

        var district=allDistrict[0]
        var districtAdapter: ArrayAdapter<String>

        val stateAdapter : ArrayAdapter<String> = ArrayAdapter(
            this,android.R.layout.simple_list_item_1,state)
        tv_state.setOnClickListener {


            val view =layoutInflater.inflate(R.layout.popup_list,null)
            window = PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            window.contentView= view

            val lv_state=view.findViewById<ListView>(R.id.lv_state)
            val iv_crossBtn=view.findViewById<ImageView>(R.id.iv_crossBtn)
            iv_crossBtn.setOnClickListener {
                if (tv_state.text=="")
                { tv_state.setBackgroundResource(R.drawable.edit_text_red_background)
                    validate_state.isVisible = true }
                else
                {tv_state.setBackgroundResource(R.drawable.edit_text_background)
                    flagGo++;validate_state.isVisible = false }

                window.dismiss()
            }
            val tv_head=view.findViewById<TextView>(R.id.tv_head)
            tv_head.text="State"
            lv_state.adapter=stateAdapter
            lv_state.setOnItemClickListener { parent, view, position, id ->
                stateIndex=position
                tv_district.text=""
                district=allDistrict[stateIndex]

                districtAdapter = ArrayAdapter(
                    this, android.R.layout.simple_list_item_1, district)
                tv_state.text=state[position]
                if (tv_state.text=="")
                { tv_state.setBackgroundResource(R.drawable.edit_text_red_background)
                    validate_state.isVisible = true }
                else
                {tv_state.setBackgroundResource(R.drawable.edit_text_background)
                    flagGo++;validate_state.isVisible = false }
                window.dismiss()
            }

            window.showAsDropDown(tv_state)
        }

        districtAdapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, district)
        /*val district=allDistrict[stateIndex]

        val districtAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, district)*/


        val block = ArrayList<String>()
        for(i in 1..30)
        {block.add("Block-"+i)
        }

        val village = ArrayList<String>()
        for(i in 1..30)
        {village.add("Village-"+i)
        }



        val blockAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, block)

        val villageAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, village)


////jkdfjkfhdjhdsjk;hf;skldjsijfijiodfjsdiojf
        tv_district.setOnClickListener {

            val view =layoutInflater.inflate(R.layout.popup_list,null)
            window = PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            window.contentView= view

            val lv_state=view.findViewById<ListView>(R.id.lv_state)
            val iv_crossBtn=view.findViewById<ImageView>(R.id.iv_crossBtn)
            iv_crossBtn.setOnClickListener {
                if (tv_district.text=="")
                { tv_district.setBackgroundResource(R.drawable.edit_text_red_background)
                    validate_district.isVisible = true }
                else
                {tv_district.setBackgroundResource(R.drawable.edit_text_background)
                    flagGo++;validate_district.isVisible = false }

                window.dismiss()
            }
            val tv_head=view.findViewById<TextView>(R.id.tv_head)
            tv_head.text="District"
            lv_state.adapter=districtAdapter
            lv_state.setOnItemClickListener { parent, view, position, id ->

                tv_district.text=district[position]
                if (tv_district.text=="")
                { tv_district.setBackgroundResource(R.drawable.edit_text_red_background)
                    validate_district.isVisible = true }
                else
                {tv_district.setBackgroundResource(R.drawable.edit_text_background)
                    flagGo++;validate_district.isVisible = false }
                window.dismiss()
            }
            window.showAsDropDown(tv_district)
        }

        tv_block.setOnClickListener {

            val view =layoutInflater.inflate(R.layout.popup_list,null)
             window = PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            window.contentView= view

            val lv_state=view.findViewById<ListView>(R.id.lv_state)
            val iv_crossBtn=view.findViewById<ImageView>(R.id.iv_crossBtn)
            iv_crossBtn.setOnClickListener {
                if (tv_block.text=="")
                { tv_block.setBackgroundResource(R.drawable.edit_text_red_background)
                    validate_block.isVisible = true }
                else
                {tv_block.setBackgroundResource(R.drawable.edit_text_background)
                    flagGo++;validate_block.isVisible = false }

                window.dismiss()
            }
            val tv_head=view.findViewById<TextView>(R.id.tv_head)
            tv_head.text="Block"
            lv_state.adapter=blockAdapter
            lv_state.setOnItemClickListener { parent, view, position, id ->
                //state[position]
                tv_block.text=block[position]
                if (tv_block.text=="")
                { tv_block.setBackgroundResource(R.drawable.edit_text_red_background)
                    validate_block.isVisible = true }
                else
                {tv_block.setBackgroundResource(R.drawable.edit_text_background)
                    flagGo++;validate_block.isVisible = false }
                window.dismiss()
            }
            window.showAsDropDown(tv_block)
        }

        tv_village.setOnClickListener {

            val view =layoutInflater.inflate(R.layout.popup_list,null)
            window = PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            window.contentView= view

            val lv_state=view.findViewById<ListView>(R.id.lv_state)
            val iv_crossBtn=view.findViewById<ImageView>(R.id.iv_crossBtn)
            val tv_head=view.findViewById<TextView>(R.id.tv_head)
            tv_head.text="Village"
            lv_state.adapter=villageAdapter


            lv_state.setOnItemClickListener { parent, view, position, id ->
                //state[position]
                tv_village.text=village[position]
                if (tv_village.text=="")
                { tv_village.setBackgroundResource(R.drawable.edit_text_red_background)
                    validate_village.isVisible = true }
                else
                {tv_village.setBackgroundResource(R.drawable.edit_text_background)
                    flagGo++;validate_village.isVisible = false }
                window.dismiss()
            }

            iv_crossBtn.setOnClickListener {
                if (tv_village.text=="")
                { tv_village.setBackgroundResource(R.drawable.edit_text_red_background)
                    validate_village.isVisible = true }
                else
                {tv_village.setBackgroundResource(R.drawable.edit_text_background)
                    flagGo++;validate_village.isVisible = false }

                window.dismiss()
            }




            window.showAsDropDown(tv_village)
        }





        iv_backButtonRegister.setOnClickListener {
            finish()
        }

/*
        et_firstName.setText("mjhsgjsjs".capitalize())*/

//        et_firstName.text =  Editable.Factory.getInstance().newEditable("mjhsgjsjs".capitalize())


        et_firstName.doOnTextChanged { text, start, before, count ->
                validateFirstName()
        }

        et_firstName.setOnFocusChangeListener { view, hasFocused ->
            if (!hasFocused)
            {if (!et_firstName.text.toString().isEmpty() && et_firstName.text[0].isLowerCase())
                    {
                        et_firstName.setText(et_firstName.text.toString().lowercase().capitalize())
                    }
            }
        }

        et_lastName.doOnTextChanged { text, start, before, count ->
        /*if(et_lastName.text.contains(" "))
            {
                et_lastName.setText(et_lastName.text.toString().split(" ")[0])
            }
                et_lastName.setText(et_lastName.text.toString().lowercase().capitalize())*/
                validateLastName()
        }
        et_lastName.setOnFocusChangeListener { view, hasFocused ->
            if (!hasFocused)
            {if (!et_lastName.text.toString().isEmpty() && et_lastName.text[0].isLowerCase())
            {
                et_lastName.setText(et_lastName.text.toString().lowercase().capitalize())
            }
            }
        }

        et_MobileNumber.doOnTextChanged { text, start, before, count ->
                validateMobileNumber()


        }
        et_MobileNumber.setOnFocusChangeListener { view, hasFocused ->
            if (!hasFocused)
            {if (!et_MobileNumber.text.toString().isEmpty() && !et_MobileNumber.text[0].isDigit())
            {
                et_MobileNumber.setText(et_MobileNumber.text.toString().substring(1))
            }
            }
        }

        et_fullAddress.doOnTextChanged { text, start, before, count ->
                validateFullAddress()

        }
        et_pinCode.doOnTextChanged { text, start, before, count ->
                validatePinCode()

        }



        btn_save.setOnClickListener{
            funValidateRegistration()
        }


    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(this, "newIntent call", Toast.LENGTH_SHORT).show()
    }

    /*private fun checkPopUpList(text: String) {
        ////
    }*/

    var flagGo=0
//    private fun funValidateRegistrarion() {
    private fun validateFirstName()
    {
        if(et_firstName.text.contains(" "))
                {
                    et_firstName.setText(et_firstName.text.toString().split(" ")[0])
                }

        if (et_firstName.text.toString().isEmpty())
        {et_firstName.setBackgroundResource(R.drawable.edit_text_red_background)
            validate_firstName.isVisible=true
            validate_firstName.text="*Please enter your first name"

        }
        else if (et_firstName.text.toString().length<3)
        {et_firstName.setBackgroundResource(R.drawable.edit_text_red_background)
            validate_firstName.isVisible=true
            validate_firstName.text="*Minimum 3 characters"
        }
        else if (et_firstName.text.toString().length>16)
        {et_firstName.setBackgroundResource(R.drawable.edit_text_red_background)
            validate_firstName.isVisible=true
            validate_firstName.text="*Maximum 16 characters"
        }

        else if (!et_firstName.text.toString()[0].isUpperCase())
        {et_firstName.setBackgroundResource(R.drawable.edit_text_red_background)
            validate_firstName.isVisible=true
            validate_firstName.text="*First letter must be capital"
        }
        else
        {
            et_firstName.setBackgroundResource(R.drawable.edit_text_background)
            validate_firstName.isVisible=false
            flagGo++
        }
    }





        ///////////////////////////////////////
        private fun validateLastName(){
            if(et_lastName.text.contains(" "))
            {
                et_lastName.setText(et_lastName.text.toString().split(" ")[0])
            }

        if (et_lastName.text.toString().isEmpty())
        {et_lastName.setBackgroundResource(R.drawable.edit_text_red_background)
            validate_lastName.isVisible=true
            validate_lastName.text="*Please enter your last name"
        }
        else if (et_lastName.text.toString().length<3)
        {et_lastName.setBackgroundResource(R.drawable.edit_text_red_background)
            validate_lastName.isVisible=true
            validate_lastName.text="*Minimum 3 characters"
        }
        else if (et_lastName.text.toString().length>16)
        {et_lastName.setBackgroundResource(R.drawable.edit_text_red_background)
            validate_lastName.isVisible=true
            validate_lastName.text="*Maximum 16 characters"
        }

        else if (!et_lastName.text.toString()[0].isUpperCase())
        {et_lastName.setBackgroundResource(R.drawable.edit_text_red_background)
            validate_lastName.isVisible=true
            validate_lastName.text="*First letter must be capital"
        }
        else
        {
            et_lastName.setBackgroundResource(R.drawable.edit_text_background)
            validate_lastName.isVisible=false
            flagGo++
        }
        }

        //////////////////////////////////////////////////mobile
        private fun validateMobileNumber() {
            if (et_MobileNumber.text.toString().isEmpty()) {
                et_MobileNumber.setBackground(getResources().getDrawable(R.drawable.edit_text_red_background))
                validate_MobileNumber.isVisible = true
                validate_MobileNumber.text = "*Please enter valid phone number"
            } else if (et_MobileNumber.text.length < 10) {
                et_MobileNumber.setBackground(getResources().getDrawable(R.drawable.edit_text_red_background))
                validate_MobileNumber.isVisible = true
                validate_MobileNumber.text = "*Please enter 10 digit"
            } else if (!et_MobileNumber.text.matches(".*[0-9].*".toRegex())) {
                et_MobileNumber.setBackground(getResources().getDrawable(R.drawable.edit_text_red_background))
                validate_MobileNumber.isVisible = true
                validate_MobileNumber.text = "*Please enter valid phone number"
            } else {
                et_MobileNumber.setBackground(getResources().getDrawable(R.drawable.edit_text_background))
                validate_MobileNumber.isVisible = false
                flagGo++
            }
        }
        /////////////////////////////////////////////mobile end
        private fun validateFullAddress() {
            if (et_fullAddress.text.toString().isEmpty()) {
                et_fullAddress.setBackground(getResources().getDrawable(R.drawable.edit_text_red_background))
                validate_fullAddress.isVisible = true
                validate_fullAddress.text = "*Please enter your full address"
            } else if (et_fullAddress.text.length < 3) {
                et_fullAddress.setBackground(getResources().getDrawable(R.drawable.edit_text_red_background))
                validate_fullAddress.isVisible = true
                validate_fullAddress.text = "*Minimum 3 characters are allowed"
            } else if (et_fullAddress.text.length > 40) {
                et_fullAddress.setBackground(getResources().getDrawable(R.drawable.edit_text_red_background))
                validate_fullAddress.isVisible = true
                validate_fullAddress.text = "*Maximum 40 characters are allowed"
            } else {
                et_fullAddress.setBackground(getResources().getDrawable(R.drawable.edit_text_background))
                validate_fullAddress.isVisible = false
                flagGo++
            }
        }
        ///////////////////////////////////////////////
        //////////////////////////////////////////////////
        private fun validatePinCode() {
            if (et_pinCode.text.toString().isEmpty()) {
                et_pinCode.setBackground(getResources().getDrawable(R.drawable.edit_text_red_background))
                validate_pinCode.isVisible = true
                validate_pinCode.text = "*Please enter valid phone number"
            } else if (et_pinCode.text.length < 6) {
                et_pinCode.setBackground(getResources().getDrawable(R.drawable.edit_text_red_background))
                validate_pinCode.isVisible = true
                validate_pinCode.text = "*Please enter 6 digit"
            } else if (!et_pinCode.text.matches(".*[0-9].*".toRegex())) {
                et_pinCode.setBackground(getResources().getDrawable(R.drawable.edit_text_red_background))
                validate_pinCode.isVisible = true
                validate_pinCode.text = "*Please enter valid pincode"
            } else {
                et_pinCode.setBackground(getResources().getDrawable(R.drawable.edit_text_background))
                validate_pinCode.isVisible = false
                flagGo++

            }
        }
        /////////////////////////////////////////////
        private fun funValidateRegistration(){
            flagGo=0
            validateFirstName()
            validateLastName()
            validateMobileNumber()
            validateFullAddress()
            if (tv_state.text=="")
            { tv_state.setBackgroundResource(R.drawable.edit_text_red_background)
                validate_state.isVisible = true }
            else
            {tv_state.setBackgroundResource(R.drawable.edit_text_background)
                flagGo++;validate_state.isVisible = false }
            if (tv_district.text=="")
            { tv_district.setBackgroundResource(R.drawable.edit_text_red_background)
                validate_district.isVisible = true }
            else
            {tv_district.setBackgroundResource(R.drawable.edit_text_background)
                flagGo++;validate_district.isVisible = false }
            if (tv_block.text=="")
            { tv_block.setBackgroundResource(R.drawable.edit_text_red_background)
                validate_block.isVisible = true }
            else
            {tv_block.setBackgroundResource(R.drawable.edit_text_background)
                flagGo++;validate_block.isVisible = false }
            if (tv_village.text=="")
            { tv_village.setBackgroundResource(R.drawable.edit_text_red_background)
                validate_village.isVisible = true }
            else
            {tv_village.setBackgroundResource(R.drawable.edit_text_background)
                flagGo++;validate_village.isVisible = false }
            validatePinCode()

            if (flagGo == 9) {
                Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@Registration, Location::class.java)
                finishAffinity()
                startActivity(intent)

            }
        }
    override fun onBackPressed() {
        if(window.isShowing()) {
            window.dismiss();
            return;
        }
        super.onBackPressed();

    }

}




