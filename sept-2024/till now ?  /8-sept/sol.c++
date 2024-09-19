class Solution {
    typedef pair<string,int> si;
    typedef pair<int,int> ii;
public:
    si getElementName(string& formula, int i){

        string str = "";
        if(isupper(formula[i])){
            str += formula[i];
            i++;
            int cnt = 1;
            while(islower(formula[i])){
                str += formula[i];
                cnt++;
                i++;
            }

            return {str,cnt};
        }else{
            return {"",1};
        }
    }

    ii getAtomsCount(string& formula, int i){
        if(isdigit(formula[i])){
            string str = "";
            int cnt = 0;
            while(isdigit(formula[i])){
                str += formula[i];
                i++;
                cnt++;
            }

            // solution by varun -> devvarunbhardwaj 
            int val = 0;
            for(int j = 0 ; j<str.length() ; j++){
                val = (val * 10) + (str[j] - '0');
            }

            // cout<<"Atoms, Count pair: "<<val<<","<<cnt<<endl;
            return {val,cnt};
        }else{
            return {1,0};
        }
    }

    void modifyStack(stack<si>& st, int cnt){
        if(st.top().first == "("){
            st.pop();
            return;
        }

        si temp = st.top();
        st.pop();
        modifyStack(st, cnt);
        st.push({temp.first, temp.second*cnt});
    }

    // void printStack(stack<si> st){
    //     stack<si> temp = st;
    //     while(!temp.empty()){
    //         cout<<"| "<<temp.top().first<<":"<<temp.top().second<<" |"<<endl;
    //         temp.pop();
    //     }
    //     cout<<" ------- "<<endl;
    //     return;
    // }


    // add your function here
    string countOfAtoms(string formula) {
        stack<si> st;
        int i = 0;

        while( i < formula.length() ){
            // either it is an opening bracket
            if(formula[i] == '('){
                st.push({"(", 0});
                i++;
                // cout<<"opening bracket inserted"<<endl;
            }else if(formula[i] == ')') { // or it is a closing bracket followed by a number
                i++;
                ii nxt = getAtomsCount(formula, i);
                modifyStack(st, nxt.first);
                i += nxt.second;
                // cout<<"closed bracket, updated the stack numbers"<<endl;
            }else if(isupper(formula[i])) { // // it is an Element name followed by a number/otherElement/bracket
                si elem = getElementName(formula, i);
                i+=elem.second;
                ii elemCnt = getAtomsCount(formula, i);
                st.push({elem.first, elemCnt.first});
                i+=elemCnt.second;
                // cout<<"found new element, inserted it to stack"<<endl;
            }
            // printStack(st);
        }

        map<string,int> mp;
        while(!st.empty()){
            if(mp.count(st.top().first)){
                mp[st.top().first] += st.top().second;
            }else{
                mp[st.top().first] = st.top().second;
            }
            st.pop();
        }

        string res = "";
        for(auto it : mp){
            res += it.first;
            if(it.second > 1){
                res += to_string(it.second);
            }
        }

        return res;
    }
};

