times=$1

let count=0
until [[ "$count" -ge "$times" ]]; do
	option=$((RANDOM%5))
	case $option in
		[0])
  			curl -X POST -d '{ "candidateName": "Donuts"}' "http://localhost:8080/api/poll" -H "Content-type: application/json"
  			echo "Option $option Donuts"
  		;;
		[1])
  			curl -X POST -d '{ "candidateName": "Bagels"}' "http://localhost:8080/api/poll" -H "Content-type: application/json"
  			echo "Option $option Bagels"
  		;;
		[2])
                        curl -X POST -d '{ "candidateName": "Sandwich"}' "http://localhost:8080/api/poll" -H "Content-type: application/json"
                        echo "Option $option Sandwich"
                ;;
		[3])
                        curl -X POST -d '{ "candidateName": "Bacon"}' "http://localhost:8080/api/poll" -H "Content-type: application/json"
                        echo "Option $option Bacon"
                ;;
		[4])
                        curl -X POST -d '{ "candidateName": "Nothing"}' "http://localhost:8080/api/poll" -H "Content-type: application/json"
                        echo "Option $option Nothing"
                ;;
	esac
	let count=count+1
	sleep 1
done
